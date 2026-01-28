package com.postechfiap.sus.msmaquina.repositories;

import com.postechfiap.sus.msmaquina.entities.OperacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperacaoRepository extends JpaRepository<OperacaoEntity, UUID> {
}
