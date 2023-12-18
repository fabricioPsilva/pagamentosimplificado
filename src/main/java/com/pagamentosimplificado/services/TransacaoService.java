package com.pagamentosimplificado.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pagamentosimplificado.domain.transacao.Transacao;
import com.pagamentosimplificado.domain.usuario.Usuario;
import com.pagamentosimplificado.dtos.TransacaoDTO;
import com.pagamentosimplificado.repositories.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TransacaoRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${validador}")
	private String validadorPagamento;
	
	public void criaTransacao(TransacaoDTO transacao) throws Exception {
		
		Usuario pagador = this.usuarioService.findUsuarioById(transacao.pagadorId());
		Usuario recebedor = this.usuarioService.findUsuarioById(transacao.recebedorId());
		
		this.usuarioService.validaTransacao(pagador, transacao.valor());
		
		boolean autorizado = this.autorizaTransacao(pagador, transacao.valor());
		
		if(!autorizado) {
			throw new Exception("Transação não autorizada");
		}
		
		Transacao novaTransacao = new Transacao();
		novaTransacao.setValorTransferido(transacao.valor());
		novaTransacao.setPagador(pagador);
		novaTransacao.setRecebedor(recebedor);
		novaTransacao.setDataTransacao(LocalDateTime.now());
		
		pagador.setSaldo(pagador.getSaldo().subtract(transacao.valor()));
		recebedor.setSaldo(recebedor.getSaldo().add(transacao.valor()));
		
		this.repository.save(novaTransacao);
		this.usuarioService.saveUsuario(pagador);
		this.usuarioService.saveUsuario(recebedor);
		
	}
	
	private boolean autorizaTransacao(Usuario pagador, BigDecimal valor) {
		ResponseEntity<Map> respostaAutorizacao = restTemplate.getForEntity(validadorPagamento, Map.class);
		
		if(respostaAutorizacao.getStatusCode() == HttpStatus.OK) {
			String mensagem = (String) respostaAutorizacao.getBody().get("message");
			return mensagem.equalsIgnoreCase("Autorizado");
		} else return false;
	}

}
