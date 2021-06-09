package com.utn.ParcialFutbol.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Jugador extends Persona{

    private float peso;
    private float altura;
    private int goles;
    private int minutosJugados;
    private String date;

    @OneToOne
    @JoinColumn(name="currency_id")
    private  Currency currency;


    @Override
    public TypePerson typePerson() {
        return TypePerson.JUGADOR;
    }
}
