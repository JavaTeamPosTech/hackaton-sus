package com.postechfiap.sus.msmaquina.dto.response;

import com.postechfiap.sus.msmaquina.entities.enums.StatusMaquina;
import com.postechfiap.sus.msmaquina.entities.enums.TipoMaquina;

import java.time.LocalDateTime;
import java.util.UUID;

public record MaquinaResponseDto (

    UUID id,
    String modelo,
    String fabricante,
    String numeroSerie,
    String localizacao,
    String codigoPatrimonio,
    TipoMaquina tipo,
    StatusMaquina status,
    LocalDateTime dataCadastro){
}
