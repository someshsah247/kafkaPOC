//package com.kafka.consumer.email.config;
//
//import com.kafka.consumer.email.dto.EmailRequest;
//import lombok.Value;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//// KafkaConsumerConfig.java - Kafka consumer configuration
//@Configuration
//public class KafkaConsumerConfig {
//
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServers;
//
//    @Bean
//    public ConsumerFactory<String, EmailRequest> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "email_group");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
//                new JsonDeserializer<>(EmailRequest.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, EmailRequest> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, EmailRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//}


/*
To configure Kafka producer properties in a Spring Boot `application.yml` file equivalent to the `producerFactory` bean configuration, write it like this:

```yaml
spring:
  kafka:
    bootstrap-servers: your-kafka-broker:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
```

### Explanation:
- `spring.kafka.bootstrap-servers` corresponds to `ProducerConfig.BOOTSTRAP_SERVERS_CONFIG`.
- `key-serializer` and `value-serializer` define the Kafka serializer classes for message keys and values, matching your Java config's `StringSerializer` and `JsonSerializer`.

Make sure to replace `your-kafka-broker:9092` with your actual Kafka broker address. Spring Boot automatically applies these settings when you use `KafkaTemplate` for producing messages.
 */