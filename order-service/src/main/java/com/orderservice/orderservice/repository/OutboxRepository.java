package com.orderservice.orderservice.repository;

import com.orderservice.orderservice.entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxRepository extends JpaRepository<Outbox, Long> {
}
