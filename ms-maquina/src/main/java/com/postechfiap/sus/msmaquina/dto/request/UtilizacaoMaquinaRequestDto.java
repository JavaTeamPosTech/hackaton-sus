package com.postechfiap.sus.msmaquina.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UtilizacaoMaquinaRequestDto(
        @NotNull
         UUID idMaquina,
        @NotNull
         UUID idOperacao
) {
}
