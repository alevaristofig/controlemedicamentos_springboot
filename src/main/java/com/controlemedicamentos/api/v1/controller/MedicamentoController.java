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

import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;
import com.controlemedicamentos.api.v1.producer.MedicamentoProducer;

@RestController
@RequestMapping(path = "v1/medicamentos", consumes = MediaType.APPLICATION_JSON_VALUE)
public class MedicamentoController {
	
	@Autowired
	private MedicamentoProducer medicamentoProducer;

	@PostMapping
	public ResponseEntity<MedicamentoDTO> adicionar(@RequestBody @Validated MedicamentoDTO medicamentoDTO) {
		medicamentoProducer.send(medicamentoDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
