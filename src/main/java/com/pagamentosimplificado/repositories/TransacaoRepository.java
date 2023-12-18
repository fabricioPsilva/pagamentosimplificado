package com.pagamentosimplificado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagamentosimplificado.domain.transacao.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
	
}
