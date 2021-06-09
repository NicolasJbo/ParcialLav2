package com.utn.ParcialFutbol.model;

public enum TypePerson {
    REPRESENTANTE("Un representante"),
    JUGADOR("Un jugador");

    private String description;

    TypePerson(String description){
        this.description = description;
    }

    public static TypePerson find(final String value) {
        for (TypePerson p : values()) {
            if (p.toString().equalsIgnoreCase(value)) {
                return p;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypePerson: %s", value));
    }
}
