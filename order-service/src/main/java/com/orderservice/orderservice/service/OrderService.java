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

         CustomerOrder order2 = orderRepository.save(order);

        Outbox outbox = new Outbox();

        outbox.setEvent("order_created");
        outbox.setEventId(order.getId());

        outbox.setPayload(order2);

        outbox.setCreatedAt(LocalDateTime.now());

        System.out.println("Outbox: " + outboxRepository.save(outbox));


        //delete immediately - still the entry will be picked up from the logs as there was an insert
        //in the previous line

        //outboxRepository.delete(outbox);
        return order2;
    }

    public Collection<CustomerOrder> findAll() {
        return orderRepository.findAll();
    }
}
