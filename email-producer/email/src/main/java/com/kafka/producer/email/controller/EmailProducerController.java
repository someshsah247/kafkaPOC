package com.kafka.producer.email.controller;

import com.kafka.shared.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email/producer")
public class EmailProducerController {

    @Autowired
    private final KafkaTemplate kafkaTemplate;

//    @Autowired
//    @Value("${kafka.email_topic}")
//    private final String topic;


    public EmailProducerController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        //this.topic = topic;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        kafkaTemplate.send("EMAIL_TOPIC2", emailRequest);
        return ResponseEntity.ok("Email request sent to Kafka");
    }


}
