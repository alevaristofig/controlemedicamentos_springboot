package com.controlemedicamentos.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlemedicamentos.api.v1.dto.UsuarioDTO;
import com.controlemedicamentos.api.v1.producer.UsuarioProducer;

@RestController
@RequestMapping(path = "v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioProducer usuarioProducer;
	
	@PostMapping()
	public ResponseEntity<UsuarioDTO> adicionar(@RequestBody @Validated UsuarioDTO usuarioDto) {
		usuarioProducer.send(usuarioDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();		
	}
}
