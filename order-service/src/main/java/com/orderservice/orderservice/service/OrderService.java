package com.orderservice.orderservice.service;

import com.orderservice.orderservice.entity.Order;
import com.orderservice.orderservice.entity.Outbox;
import com.orderservice.orderservice.repository.OrderRepository;
import com.orderservice.orderservice.repository.OutboxRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OutboxRepository outboxRepository;

    public OrderService(OrderRepository orderRepository, OutboxRepository outboxRepository) {
        this.orderRepository = orderRepository;
        this.outboxRepository = outboxRepository;
    }

    public Order save(Order order) {

        order = orderRepository.save(order);

        Outbox outbox = new Outbox();

        outbox.setEvent("order_created");
        outbox.setEventId(order.getId());

        outbox.setPayload(order);

        outbox.setCreatedAt(LocalDateTime.now());

        System.out.println("Outbox: " + outboxRepository.save(outbox));


        //delete immediately - still the entry will be picked up from the logs as there was an insert
        //in the previous line

        outboxRepository.delete(outbox);
        return order;
    }

    public Collection<Order> findAll() {
        return orderRepository.findAll();
    }
}
