package com.pmu.backend.api.common.configuration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumerConfig {

    @KafkaListener(topics = "course-created", groupId = "course-consumer")
    public void consumeCourseCreatedEvent(String message) {
        System.out.println("Course Created Event Received: " + message);
    }

    @KafkaListener(topics = "partant-created", groupId = "partant-consumer")
    public void consumePartantCreatedEvent(String message) {
        System.out.println("Partant Created Event Received: " + message);
    }
}
