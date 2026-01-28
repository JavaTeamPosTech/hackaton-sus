package com.postechfiap.sus.ms_operacao_maquina.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "utilizacoes_maquinas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UtilizacaoMaquinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "id_maquina", nullable = false)
    private UUID idMaquina;

    @Column(name = "id_operacao", nullable = false)
    private UUID idOperacao;

    @Column(name = "data_utilizacao", nullable = false)
    private LocalDateTime dataUtilizacao;
}
