package com.controlemedicamentos.api.v1.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.AplicacaoDTO;

@Component
public class AplicacaoProducer {

	private static final Logger logger = LoggerFactory.getLogger(AplicacaoProducer.class);
	private final String topic;
	private final KafkaTemplate<String, AplicacaoDTO> kafkaTemplate;
	
	public AplicacaoProducer(@Value("${topic.aplicacao-producer}") String topic,
			KafkaTemplate<String, AplicacaoDTO> kafkaTemplate) {
		
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(AplicacaoDTO aplicacaoDTO) {
		try {
			kafkaTemplate.send(topic, aplicacaoDTO);
			
			logger.info("Mensagem enviada"+ aplicacaoDTO);
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}
