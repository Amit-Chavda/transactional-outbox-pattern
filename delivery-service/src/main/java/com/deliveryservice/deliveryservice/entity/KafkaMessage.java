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
public class KafkaMessage {
    private LocalDateTime receivedAt;
    private Payload payload;
}
