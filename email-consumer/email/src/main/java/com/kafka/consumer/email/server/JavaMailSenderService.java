package com.kafka.consumer.email.server;

import com.kafka.shared.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaMailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${my-gmail.email}")
    private String fromEmail;


    // String to, String subject, String body
    public void sendEmail(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(request.getToEmail());
        message.setSubject(request.getSubject());
        message.setText(request.getBody());
        mailSender.send(message);
    }
}
