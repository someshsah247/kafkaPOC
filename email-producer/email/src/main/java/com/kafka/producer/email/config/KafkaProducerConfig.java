//package com.kafka.producer.email.config;
//
//import com.kafka.producer.email.dto.EmailRequest;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//// KafkaProducerConfig.java - Kafka producer configuration
//@Configuration
//public class KafkaProducerConfig {
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServers;
//
//    @Bean
//    public ProducerFactory<String, EmailRequest> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, EmailRequest> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}
//


/*
spring:
  kafka:
    bootstrap-servers: your-kafka-broker:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer

Explanation:
spring.kafka.bootstrap-servers corresponds to ProducerConfig.BOOTSTRAP_SERVERS_CONFIG.

key-serializer and value-serializer define the Kafka serializer classes for message keys and values, matching your Java config's StringSerializer and JsonSerializer.

Make sure to replace your-kafka-broker:9092 with your actual Kafka broker address. Spring Boot automatically applies these settings when you use KafkaTemplate for producing messages.
 */