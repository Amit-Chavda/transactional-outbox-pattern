package com.orderservice.orderservice.repository;

import com.orderservice.orderservice.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder,Long> {
}
