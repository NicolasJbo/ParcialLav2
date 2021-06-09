package com.utn.ParcialFutbol.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invitado {

    private String name;
    private String currency;
    private Float amount;

    public static Invitado getInvitadoFrom(Jugador jugador){
        return Invitado.builder().name(jugador.getName())
                .currency(jugador.getCurrency().typeCurrency.getDescription())
                .amount(jugador.getCurrency().getMonto())
                .build();

    }

}
