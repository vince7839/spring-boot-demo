package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Product {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Integer count;
}
