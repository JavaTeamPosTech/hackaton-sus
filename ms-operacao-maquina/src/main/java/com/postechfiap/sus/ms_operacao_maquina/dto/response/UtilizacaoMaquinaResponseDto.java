package com.postechfiap.sus.ms_operacao_maquina.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UtilizacaoMaquinaResponseDto(
        UUID id,
        UUID idMaquina,
        UUID idOperacao,
        LocalDateTime dataUtilizacao
){
}
