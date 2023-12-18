package com.pagamentosimplificado.dtos;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal valor, Long pagadorId, Long recebedorId) {}
