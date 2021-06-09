package com.utn.ParcialFutbol.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EuroResponse {

    @SerializedName("dolar")
    private ApiCotizacion cotizacion;


}
