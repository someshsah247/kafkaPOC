package com.kafka.shared.dto;


public class EmailRequest {

    private String toEmail;
    private String name;
    private String subject;
    private String body;

    public EmailRequest(String toEmail, String name, String subject, String body) {
        this.toEmail = toEmail;
        this.name = name;
        this.subject = subject;
        this.body = body;
    }

    public EmailRequest() {
    }


    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "toEmail='" + toEmail + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}