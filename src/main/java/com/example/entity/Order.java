package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "t_order")
public class Order {
    @Id
    @GeneratedValue
    Long id;
    Long productId;
    Long userId;
    Integer count;
}
