package com.controlemedicamentos.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import com.controlemedicamentos.api.v1.dto.PacienteDTO;
import com.controlemedicamentos.api.v1.dto.UsuarioDTO;

@Component
@Configuration
public class KafkaProducerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Value("${topic.usuario-producer}")
	private String topicUsuarios;
	
	@Value("${topic.paciente-producer}")
	private String topicPacientes;
	
	@Bean
	public NewTopic createTopicUsuarios() {
		return new NewTopic(topicUsuarios,3,(short) 1);
	}
	
	@Bean
	public NewTopic createTopicPacientes() {
		return new NewTopic(topicPacientes,3,(short) 1);
	}
	
	@Bean
	public ProducerFactory<String, UsuarioDTO> usuarioProducerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	@Bean
	public ProducerFactory<String, PacienteDTO> pacienteProducerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	@Bean
	public KafkaTemplate<String, UsuarioDTO> usuarioKafkaTemplate() {
		return new KafkaTemplate<>(usuarioProducerFactory());
	}
	
	@Bean
	public KafkaTemplate<String, PacienteDTO> pacienteKafkaTemplate() {
		return new KafkaTemplate<>(pacienteProducerFactory());
	}
}
