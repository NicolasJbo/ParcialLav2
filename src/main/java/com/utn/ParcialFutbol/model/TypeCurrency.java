package com.utn.ParcialFutbol.model;

public enum TypeCurrency {

        DOLAR("USD",50),
        EURO("EUR",100);


        private String description;
        private Integer cotizacion;

        TypeCurrency(String description ,Integer cotizacion) {
            this.description = description;
            this.cotizacion=cotizacion;
        }

        public String getDescription() {
            return description;
        }

        public Integer getCotizacion() {
            return cotizacion;
        }

        public static TypeCurrency find(final String value) {
            for (TypeCurrency n : values()) {
                if (n.toString().equalsIgnoreCase(value)) {
                    return n;
                }
            }
            throw new IllegalArgumentException(String.format("Invalid TypeCurrency: %s", value));
        }


}
