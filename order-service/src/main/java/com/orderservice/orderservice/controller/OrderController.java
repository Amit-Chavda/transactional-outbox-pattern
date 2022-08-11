package com.orderservice.orderservice.controller;


import com.orderservice.orderservice.entity.Order;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        return service.save(order);

    }
}
