package com.pagamentosimplificado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagamentosimplificado.domain.usuario.Usuario;
import com.pagamentosimplificado.dtos.UsuarioDto;
import com.pagamentosimplificado.services.UsuarioService;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> criaUsuario(@RequestBody UsuarioDto usuario){
		
		Usuario novoUsuario = usuarioService.criaUsuario(usuario);
		
		return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		 List<Usuario> usuarios = this.usuarioService.getAllUsuarios();
		 
		 return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

}
