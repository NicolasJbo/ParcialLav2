package com.utn.ParcialFutbol.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiCotizacion {

    @SerializedName("nombre")
    private String nombre;
    @SerializedName("compra")
    private String compra;
    @SerializedName("venta")
    private String venta;
}
