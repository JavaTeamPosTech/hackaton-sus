package com.postechfiap.sus.ms_operacao_maquina.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UtilizacaoMaquinaRequestDto(
        @NotNull
         UUID idMaquina,
        @NotNull
         UUID idOperacao
) {
}
