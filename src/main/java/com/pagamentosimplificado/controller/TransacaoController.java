package com.pagamentosimplificado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagamentosimplificado.domain.transacao.Transacao;
import com.pagamentosimplificado.dtos.TransacaoDTO;
import com.pagamentosimplificado.services.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<Transacao> criaTransacao(@RequestBody TransacaoDTO transacao) throws Exception {
		Transacao criaTransacao = this.transacaoService.criaTransacao(transacao);
		return new ResponseEntity<>(criaTransacao, HttpStatus.CREATED);
	}

}
