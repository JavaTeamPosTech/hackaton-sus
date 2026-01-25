package com.postechfiap.sus.msmaquina.entities;

import com.postechfiap.sus.msmaquina.entities.enums.StatusMaquina;
import com.postechfiap.sus.msmaquina.entities.enums.TipoMaquina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "maquinas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaquinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String modelo;
    private String fabricante;
    private String numeroSerie;
    private String localizacao;
    private String codigoPatrimonio;

    @Enumerated(EnumType.STRING)
    private TipoMaquina tipo;

    @Enumerated(EnumType.STRING)
    private StatusMaquina status;

    private LocalDateTime dataCadastro;

}
