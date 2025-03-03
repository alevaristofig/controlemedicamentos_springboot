package com.controlemedicamentos.api.v1.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.MedicamentoDTO;

@Component
public class MedicamentoProducer {

	private static final Logger logger = LoggerFactory.getLogger(MedicamentoProducer.class);
	private final String topic;
	private final KafkaTemplate<String, MedicamentoDTO> kafkaTemplate;
	
	public MedicamentoProducer(@Value("${topic.medicamento-producer}") String topic,
			KafkaTemplate<String, MedicamentoDTO> kafkaTemplate) {
		
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(MedicamentoDTO medicamentoDto) {
		try {
			kafkaTemplate.send(topic, medicamentoDto);
			
			logger.info("Mensagem enviada"+ medicamentoDto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
