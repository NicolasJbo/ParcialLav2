package com.utn.ParcialFutbol.service;

import com.utn.ParcialFutbol.model.*;
import com.utn.ParcialFutbol.repository.CumpleanitoReposiroty;
import com.utn.ParcialFutbol.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CumpleanioService {
    @Autowired
    private Personaservice personaservice;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ApiService  apiService;

    @Autowired
    private CumpleanitoReposiroty cumpleanitoReposiroty;


    public void  add(LocalDate date , Integer idCumpleanios){
        Persona person = personaservice.getPersonById(idCumpleanios);

        Cumpleanito cumple = Cumpleanito.builder().fecha(date).cumpleaniero(person).build();

        person.getCumpleanitos().add(cumple);
        personaRepository.save(person);
       cumpleanitoReposiroty.save(cumple);

    }
    public List<Cumpleanito> getAll() {
        return cumpleanitoReposiroty.findAll();

    }
    public void addInvitadosToCumple(Integer idCumple, Integer idInvitado) {
        Cumpleanito cumple = cumpleanitoReposiroty.findById(idCumple) .orElseThrow( ()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        Persona persona = personaservice.getPersonById(cumple.getCumpleaniero().getId());
        Persona invitado =personaservice.getPersonById(idInvitado);

        invitado.getCumpleanitos().add(cumple);
        cumple.getInvitados().add(invitado);
        persona.getCumpleanitos().add(cumple);

        personaRepository.save(invitado);
        personaRepository.save(persona);
        cumpleanitoReposiroty.save(cumple);
    }

    public List<Invitado> getInvitados(Integer idCumple) throws IOException, InterruptedException {

        Cumpleanito cumple = cumpleanitoReposiroty.findById(idCumple).orElseThrow( ()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        Set<Persona> invitados = cumple.getInvitados();

        List<Invitado>listRta=new ArrayList<>();

        ApiCotizacion euro = apiService.getCotizacionEuro();
        ApiCotizacion dolar=apiService.getCotizacionDolar();

        Invitado invitado;
        Float conversion=0F;
        for (Persona p : invitados){
            conversion=0F;
            if(p instanceof Jugador){
                invitado=Invitado.getInvitadoFrom((Jugador) p);
                if(((Jugador) p).getCurrency().typeCurrency.getDescription().equals("EURO")){
                    conversion=invitado.getAmount() / Float.valueOf(euro.getCompra());
                }
                if(((Jugador) p).getCurrency().typeCurrency.getDescription().equals("DOLAR")){
                    conversion=invitado.getAmount() / Float.valueOf(dolar.getCompra());
                }
                invitado.setAmount(conversion);
                listRta.add(invitado);
            }
        }
        return listRta;
    }
}
