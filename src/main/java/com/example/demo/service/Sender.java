package com.example.demo.service;

import com.example.demo.domain.DemoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Value("${spring.kafka.template.default-topic}")
    private String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Sender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(DemoClass demoClass) {
        System.out.println("Sending " + demoClass.toString());
        kafkaTemplate.send(topic, demoClass.toString());
    }
}
