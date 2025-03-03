package com.controlemedicamentos.api.v1.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class MedicamentoDTO {

	private String nome;
	
	private BigDecimal preco;
	
	private Integer quantidade;
	
	private Boolean manipulado;
}
