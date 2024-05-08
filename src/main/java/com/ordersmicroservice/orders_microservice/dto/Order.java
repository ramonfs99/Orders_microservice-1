package com.ordersmicroservice.orders_microservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;
    private Long user_id;
    private String from_address;
    private String to_address;
    private String status;
    private String date_ordered;
    private String date_delivered;

    public Order(Long id, Long user_id, String from_address, String to_address, String status, String date_ordered, String date_delivered) {
        this.id = id;
        this.user_id = user_id;
        this.from_address = from_address;
        this.to_address = to_address;
        this.status = status;
        this.date_ordered = date_ordered;
        this.date_delivered = date_delivered;
    }
}
