package com.pagamentosimplificado.domain.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.pagamentosimplificado.domain.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "transacoes")
@Table(name = "transacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valorTransferido;
	@ManyToOne
	@JoinColumn(name = "pagador_id")
	private Usuario pagador;
	@ManyToOne
	@JoinColumn(name = "recebedor_id")
	private Usuario recebedor;
	private LocalDateTime dataTransacao;
	
	
	
	
	
	
	
	
	
	
	
	
}
