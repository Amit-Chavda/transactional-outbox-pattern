package com.deliveryservice.deliveryservice.service;

import com.deliveryservice.deliveryservice.entity.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @KafkaListener(topics = "order_server.order.outbox")
    public void receive(KafkaMessage message) {
        System.out.println(message);
    }
}
