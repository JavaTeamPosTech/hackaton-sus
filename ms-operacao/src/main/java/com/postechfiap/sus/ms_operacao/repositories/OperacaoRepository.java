package com.postechfiap.sus.ms_operacao.repositories;

import com.postechfiap.sus.ms_operacao.entities.OperacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperacaoRepository extends JpaRepository<OperacaoEntity, UUID> {
}
