package com.kafka.consumer.email.controller;

import com.kafka.consumer.email.server.JavaMailSenderService;
import com.kafka.shared.dto.EmailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailListener  {

    private final JavaMailSenderService javaMailSenderService;

    public EmailListener(JavaMailSenderService javaMailSenderService) {
        this.javaMailSenderService = javaMailSenderService;
    }


    @KafkaListener(topics = "EMAIL_TOPIC2", groupId = "email-consumer-group")
    public void listen(EmailRequest emailRequest) {
        // Now the parameter matches the deserialized object
        log.debug("Received EmailRequest: {}", emailRequest);
        javaMailSenderService.sendEmail(emailRequest);
    }


}
