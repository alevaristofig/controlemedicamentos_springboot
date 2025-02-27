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
public class UsuarioDTO {

	private String nome;
	
	private String email;
	
	private String senha;
}
