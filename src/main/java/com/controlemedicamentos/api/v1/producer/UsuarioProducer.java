package com.controlemedicamentos.api.v1.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.controlemedicamentos.api.v1.dto.UsuarioDTO;


@Component
public class UsuarioProducer {

	private static final Logger logger =  LoggerFactory.getLogger(UsuarioProducer.class);
	private final String topic;
	private final KafkaTemplate<String, UsuarioDTO> kafkaTemplate;
	
	public UsuarioProducer(@Value("${topic.name-producer}") String topic,
			KafkaTemplate<String, UsuarioDTO> kafkaTemplate) {
		
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(UsuarioDTO usuarioDTO) {
		try {			
			kafkaTemplate.send(topic,usuarioDTO);	
			
			logger.info("Mensagem enviada "+usuarioDTO);
		} catch (Exception e) {
			logger.error("Erro {} ", e.getCause());
		}
	}
}
