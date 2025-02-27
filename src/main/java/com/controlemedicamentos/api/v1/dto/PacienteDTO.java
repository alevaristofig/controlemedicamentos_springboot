package com.controlemedicamentos.api.v1.dto;

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
public class PacienteDTO {

	private String nome;
	
	private String raca;
	
	private Double peso;
	
	private String cor;
	
	private Integer idade;
}
