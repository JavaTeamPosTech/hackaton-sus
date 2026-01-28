package com.postechfiap.sus.ms_operacao_maquina.repositories;

import com.postechfiap.sus.ms_operacao_maquina.entities.ManutencaoMaquinaEntity;
import com.postechfiap.sus.ms_operacao_maquina.entities.UtilizacaoMaquinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManutencaoMaquinaRepository extends JpaRepository<ManutencaoMaquinaEntity, UUID> {
}
