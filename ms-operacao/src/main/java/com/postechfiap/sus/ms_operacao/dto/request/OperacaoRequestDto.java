package com.postechfiap.sus.ms_operacao.dto.request;

import com.postechfiap.sus.ms_operacao.entities.enums.StatusOperacao;
import com.postechfiap.sus.ms_operacao.entities.enums.TipoOperacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record OperacaoRequestDto(

        @NotNull
        TipoOperacao tipo,

        @NotNull
        UUID idPaciente,

        @NotNull
        UUID idProfissional,

        @NotNull
        LocalDateTime dataHora,

        String descricao,
        StatusOperacao status
) {
}