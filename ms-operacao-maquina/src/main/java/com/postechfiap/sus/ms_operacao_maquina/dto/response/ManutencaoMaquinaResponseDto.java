package com.postechfiap.sus.ms_operacao_maquina.dto.response;

import com.postechfiap.sus.ms_operacao_maquina.entities.enums.StatusManutencao;
import com.postechfiap.sus.ms_operacao_maquina.entities.enums.TipoManutencao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ManutencaoMaquinaResponseDto(

        UUID id,
        UUID idMaquina,
        TipoManutencao tipo,
        StatusManutencao status,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String descricao,
        String observacoes,
        boolean maquinaIndisponivel,
        BigDecimal custoManutencao

) {
}