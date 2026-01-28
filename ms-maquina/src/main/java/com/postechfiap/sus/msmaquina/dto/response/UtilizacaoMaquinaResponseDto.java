package com.postechfiap.sus.msmaquina.dto.response;

import com.postechfiap.sus.msmaquina.entities.enums.StatusMaquina;
import com.postechfiap.sus.msmaquina.entities.enums.TipoMaquina;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

public record UtilizacaoMaquinaResponseDto(
        UUID id,
        UUID idMaquina,
        UUID idOperacao,
        LocalDateTime dataUtilizacao
){
}
