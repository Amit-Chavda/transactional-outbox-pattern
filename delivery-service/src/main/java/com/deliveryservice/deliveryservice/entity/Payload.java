package com.deliveryservice.deliveryservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payload {
    private int id;
    private String event;
    private int eventId;
    private String payload;
    private String createdAt;
}
