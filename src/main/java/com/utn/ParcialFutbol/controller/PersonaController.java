package com.utn.ParcialFutbol.controller;

import com.utn.ParcialFutbol.model.Persona;
import com.utn.ParcialFutbol.model.Representante;
import com.utn.ParcialFutbol.service.Personaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonaController {

    @Autowired
    Personaservice personaservice;

    @PostMapping
    public void addPerson(@RequestBody Persona person){
        personaservice.add(person);
    }

    @GetMapping
    public List<Persona> getAll(@RequestParam(required = false) String name){
        return personaservice.getAll(name);
    }

    @GetMapping("/{id}")
    public Persona getPersonById(@PathVariable Integer id){
        return personaservice.getPersonById(id);
    }




    @GetMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Integer id){
        personaservice.deletePersonById(id);
    }

    @PutMapping("/representante/{idRepresentante}/jugador/{idJugador}")
    public void addJugadorToRepresentante(@PathVariable Integer idRepresentante, @PathVariable Integer idJugador){
        personaservice.addJugadorToRepresentante(idRepresentante,idJugador);
    }

    @PutMapping("/jugador/{idJugador}/currency/{idCurrency}")
    public void addCurrencyToJugador(@PathVariable Integer idJugador, @PathVariable Integer idCurrency){
        personaservice.addCurrencyToJugador(idJugador,idCurrency);
    }








}
