package com.postechfiap.sus.ms_operacao_maquina.dto.request;

import com.postechfiap.sus.ms_operacao_maquina.entities.enums.TipoManutencao;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ManutencaoMaquinaRequestDto(

        @NotNull
        UUID idMaquina,

        @NotNull
        TipoManutencao tipo,

        @NotNull
        LocalDateTime dataInicio,

        String descricao,

        boolean maquinaIndisponivel,

        BigDecimal custoManutencao

) {
}