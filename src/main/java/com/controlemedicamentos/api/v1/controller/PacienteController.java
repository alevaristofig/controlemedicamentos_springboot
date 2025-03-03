package com.controlemedicamentos.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.api.v1.producer.PacienteProducer;

@RestController
@RequestMapping(path = "v1/pacientes", consumes = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
	
	@Autowired
	private PacienteProducer pacienteProducer;

	@PostMapping
	public ResponseEntity<PacienteDTO> adicionar(@RequestBody @Validated PacienteDTO pacienteDTO) {
		pacienteProducer.send(pacienteDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
