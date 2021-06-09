package com.utn.ParcialFutbol.service;

import com.utn.ParcialFutbol.model.*;
import com.utn.ParcialFutbol.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class Personaservice {

    @Autowired
    public Personaservice(PersonaRepository personaRepository, CurrencyService currencyService) {
        this.personaRepository = personaRepository;
        this.currencyService = currencyService;
    }

    PersonaRepository personaRepository;
    CurrencyService currencyService;
    public List<Persona> getAll(String name) {
        if(isNull(name))
            return personaRepository.findAll();
        else
            return personaRepository.findByName(name);
    }

    public void add(Persona person) {

        personaRepository.save(person);
    }

    public Persona getPersonById(Integer id) {

        Persona persona = personaRepository.findById(id)
                .orElseThrow( ()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));



        return persona;
    }

    public void deletePersonById(Integer id) {
        personaRepository.delete( getPersonById(id) );
    }

    public void addJugadorToRepresentante(Integer idRepresentante, Integer idJugador) {
        Representante representante = (Representante) getPersonById(idRepresentante);
        Jugador jugador = (Jugador) getPersonById(idJugador);

        //Agrego el jugador a la lista del representante
        representante.getJugadoresList().add(jugador);
        representante.setTotalAmount();

        personaRepository.save(representante);
    }

    public void addCurrencyToJugador(Integer idJugador, Integer idCurrency) {
        Currency currency = currencyService.getCurrencyById(idCurrency);
        Jugador jugador = (Jugador) getPersonById(idJugador);
        jugador.setCurrency(currency);
        personaRepository.save(jugador);
    }
}
