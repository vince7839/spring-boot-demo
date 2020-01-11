package com.example;

import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.interfaces.ECKey;
import java.util.UUID;

@Component
public class BeanA {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void test(){
        Product p = new Product();
        String s = UUID.randomUUID().toString().substring(0,5);
        p.setName(s);
        productRepository.save(p);

        int a = 1/0;

        Order order = new Order();
        order.setCount(1);
        orderRepository.save(order);
    }
}
