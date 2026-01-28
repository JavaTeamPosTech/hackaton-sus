package com.postechfiap.sus.msmaquina.entities;

import com.postechfiap.sus.msmaquina.entities.enums.StatusOperacao;
import com.postechfiap.sus.msmaquina.entities.enums.TipoOperacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operacao")
public class OperacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoOperacao tipo;

    @Column(name = "id_paciente", nullable = false)
    private UUID idPaciente;

    @Column(name = "id_profissional", nullable = false)
    private UUID idProfissional;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOperacao status;
}

