package com.postechfiap.sus.ms_operacao_maquina.entities;

import com.postechfiap.sus.ms_operacao_maquina.entities.enums.StatusManutencao;
import com.postechfiap.sus.ms_operacao_maquina.entities.enums.TipoManutencao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "manutencoes_maquinas")
public class ManutencaoMaquinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "id_maquina", nullable = false)
    private UUID idMaquina;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoManutencao tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusManutencao status;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    private String descricao;

    private String observacoes;

    @Column(name = "maquina_indisponivel", nullable = false)
    private boolean maquinaIndisponivel;

    @Column(name = "custo_manutencao")
    private BigDecimal custoManutencao;
}

