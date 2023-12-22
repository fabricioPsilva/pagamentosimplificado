package com.pagamentosimplificado.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pagamentosimplificado.dtos.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControleExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity tratamentoEntradaDuplicada(DataIntegrityViolationException exception) {
		ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário ja cadastrado", "400");
		return ResponseEntity.badRequest().body(exceptionDTO);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratamento404(EntityNotFoundException exception) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity tratamentoException(Exception exception) {
		ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
		return ResponseEntity.internalServerError().body(exception);
	}
	
}
