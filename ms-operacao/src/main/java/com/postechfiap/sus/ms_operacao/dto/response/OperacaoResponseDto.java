package com.postechfiap.sus.ms_operacao.dto.response;

import com.postechfiap.sus.ms_operacao.entities.enums.StatusOperacao;
import com.postechfiap.sus.ms_operacao.entities.enums.TipoOperacao;

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