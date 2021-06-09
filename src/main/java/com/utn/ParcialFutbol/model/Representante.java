package com.utn.ParcialFutbol.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Representante extends Persona{


    private float pesoBoveda;
    private float montoTotal;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugadores_id")
    private List<Jugador>jugadoresList;

    @Override
    public TypePerson typePerson() {
        return TypePerson.REPRESENTANTE;
    }

    public void setTotalAmount(){
        float acumulador = 0;
        for (Jugador jug : jugadoresList){
         acumulador +=  jug.getCurrency().getMonto() * jug.getCurrency().typeCurrency.getCotizacion();
     }
        this.montoTotal =  acumulador;
        this.pesoBoveda=acumulador/1000;
    }


}
