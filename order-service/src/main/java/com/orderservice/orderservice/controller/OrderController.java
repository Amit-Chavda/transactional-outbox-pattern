package com.orderservice.orderservice.controller;

import com.orderservice.orderservice.entity.CustomerOrder;
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
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return service.save(order);
    }
}
