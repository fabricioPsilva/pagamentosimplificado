package com.pagamentosimplificado.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamentosimplificado.domain.usuario.TipoUsuario;
import com.pagamentosimplificado.domain.usuario.Usuario;
import com.pagamentosimplificado.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public void validaTransacao(Usuario pagador, BigDecimal valor) throws Exception {
		if(pagador.getTipoUsuario() == TipoUsuario.LOGISTA) {
			throw new Exception("Usuário do tipo logista não esta autorizado a realizar pagamentos.");
		}
		
		if(pagador.getSaldo().compareTo(valor) < 0) {
			throw new Exception("Saldo Insuficiente.");
		}
	}
	
	public Usuario findUsuarioById(Long id) throws Exception {
		return this.repository.findUsuarioById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
	}
	
	public void saveUsuario(Usuario usuario) {
		this.repository.save(usuario);
	}
	
}
