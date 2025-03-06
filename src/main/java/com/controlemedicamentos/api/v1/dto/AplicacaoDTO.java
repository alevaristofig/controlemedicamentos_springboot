package com.controlemedicamentos.api.v1.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AplicacaoDTO {
	
	private PacienteIdDTO pacienteId;

	private MedicamentoIdDTO medicamentoId;	
	
	private LocalDateTime dataAplicacao;
}
