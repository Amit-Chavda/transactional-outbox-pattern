package com.orderservice.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Outbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String event;
    private long eventId;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerOrder payload;
    private LocalDateTime createdAt;
}