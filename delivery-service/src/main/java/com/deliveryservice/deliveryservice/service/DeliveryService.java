package com.deliveryservice.deliveryservice.service;

import com.deliveryservice.deliveryservice.entity.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @KafkaListener(topics = "order-server.order-service.outbox")
    public void receive(@Payload(required = false) KafkaMessage message) {
        System.out.println(message);
    }
}
