package com.postechfiap.sus.msmaquina.dto;

import com.postechfiap.sus.msmaquina.entities.enums.TipoMaquina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MaquinaRequestDto (

    @NotBlank
    String modelo,

    @NotBlank
    String fabricante,

    @NotBlank
    String numeroSerie,

    @NotBlank
    String localizacao,

    @NotBlank
    String codigoPatrimonio,

    @NotNull
    TipoMaquina tipo){
}
