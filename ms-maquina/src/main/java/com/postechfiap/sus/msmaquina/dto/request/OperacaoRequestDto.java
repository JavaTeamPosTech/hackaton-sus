package com.postechfiap.sus.msmaquina.dto.request;

import com.postechfiap.sus.msmaquina.entities.enums.StatusOperacao;
import com.postechfiap.sus.msmaquina.entities.enums.TipoOperacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

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