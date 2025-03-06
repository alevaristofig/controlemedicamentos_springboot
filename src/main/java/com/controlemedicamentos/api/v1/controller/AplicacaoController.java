package com.controlemedicamentos.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;
import com.controlemedicamentos.api.v1.producer.AplicacaoProducer;

@RestController
@RequestMapping(path = "v1/aplicacao", consumes = MediaType.APPLICATION_JSON_VALUE)
public class AplicacaoController {
	
	@Autowired
	private AplicacaoProducer aplicacaoProducer;

	@PostMapping
	public ResponseEntity<AplicacaoDTO> salvar(AplicacaoDTO aplicacaoDTO) {
		aplicacaoProducer.send(aplicacaoDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
