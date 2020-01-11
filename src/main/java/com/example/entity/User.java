package com.example.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    Integer uid;
    String userName;
    String passWord;
}
