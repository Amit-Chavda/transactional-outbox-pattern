package com.deliveryservice.deliveryservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payload {
    private int id;
    private String event;
    private long eventId;
    private String  orderInfo;
    private LocalDateTime createdAt;
}
