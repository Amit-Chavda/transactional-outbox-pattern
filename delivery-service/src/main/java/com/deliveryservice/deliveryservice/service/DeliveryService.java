package com.deliveryservice.deliveryservice.service;

import com.deliveryservice.deliveryservice.entity.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryService {
    @KafkaListener(topics = "order_server.orders.outbox")
    public void receive(KafkaMessage message) {
        if (message != null) {
            System.out.println(message);
        } else {
            System.out.println("Empty message received!");
        }

    }
}