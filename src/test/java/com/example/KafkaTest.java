package com.example;

import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaTest {

    @Autowired
    KafkaTemplate template;

    @Autowired
    BeanA bean;

    //@Test
    public void test(){
        System.out.println("test");
        template.send("t","1");
    }

    @Test
    public void test2(){
        bean.test();
    }
}
