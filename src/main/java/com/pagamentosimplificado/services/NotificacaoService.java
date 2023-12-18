package com.pagamentosimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pagamentosimplificado.domain.usuario.Usuario;
import com.pagamentosimplificado.dtos.NotificacaoDTO;

@Service
public class NotificacaoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${servidorEmail}")
	private String servidorEmail;
	
	public void enviarNotificacao(Usuario usuario, String mensagem) throws Exception {
		String email = usuario.getEmail();
		NotificacaoDTO notificacao = new NotificacaoDTO(email, mensagem);
		
		ResponseEntity<String> respostaNotificacao = restTemplate.postForEntity(servidorEmail, notificacao, String.class);
		
		if(!(respostaNotificacao.getStatusCode() == HttpStatus.OK)) {
			System.out.println("Erro ao enviar notificação");
			throw new Exception("Serviço de notificação esta fora do ar");
		}
	}

}
