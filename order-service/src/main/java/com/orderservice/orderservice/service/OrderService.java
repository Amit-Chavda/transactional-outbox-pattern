package com.orderservice.orderservice.service;

import com.orderservice.orderservice.entity.CustomerOrder;
import com.orderservice.orderservice.entity.Outbox;
import com.orderservice.orderservice.repository.OrderRepository;
import com.orderservice.orderservice.repository.OutboxRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private OutboxRepository outboxRepository;

    public OrderService(OrderRepository orderRepository, OutboxRepository outboxRepository) {
        this.orderRepository = orderRepository;
        this.outboxRepository = outboxRepository;
    }

    public CustomerOrder save(CustomerOrder order) {

        order = orderRepository.save(order);


        Outbox payload = new Outbox();
        payload.setEvent("order_created");
        payload.setEventId(order.getId());
        payload.setCustomerOrder(order);
        payload.setCreatedAt(LocalDateTime.now());

        //delete immediately - still the entry will be picked up from the logs as there was an insert
        //in the previous line
        outboxRepository.delete(payload);
        return order;
    }

    public Collection<CustomerOrder> findAll() {
        return orderRepository.findAll();
    }
}
