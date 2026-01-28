package com.postechfiap.sus.msmaquina.dto.response;


import com.postechfiap.sus.msmaquina.entities.enums.StatusOperacao;
import com.postechfiap.sus.msmaquina.entities.enums.TipoOperacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record OperacaoResponseDto(

        UUID id,
        TipoOperacao tipo,
        UUID idPaciente,
        UUID idProfissional,
        LocalDateTime dataHora,
        String descricao,
        StatusOperacao status
) {
}