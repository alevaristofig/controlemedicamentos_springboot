package com.controlemedicamentos.api.v1.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.PacienteDTO;

@Component
public class PacienteProducer {

	private static final Logger logger = LoggerFactory.getLogger(PacienteProducer.class);
	private String topic;
	private final KafkaTemplate<String, PacienteDTO> kafkaTemplate;
	
	public PacienteProducer(@Value("${topic.paciente-producer}") String topic,
			KafkaTemplate<String, PacienteDTO> kafkaTemplate) {
		
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(PacienteDTO pacienteDTO) {
		try {
			kafkaTemplate.send(topic, pacienteDTO);
			
			logger.info("Mensagem enviada "+pacienteDTO);
		} catch (Exception e) {
			logger.error("Erro {} ", e.getCause());
		}
	}
}
