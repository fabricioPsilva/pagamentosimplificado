package com.pagamentosimplificado.dtos;

import java.math.BigDecimal;

import com.pagamentosimplificado.domain.usuario.TipoUsuario;

public record UsuarioDto(String nome, String sobreNome, String documento, BigDecimal saldo, String email, String senha, TipoUsuario tipoUsuario) {}
