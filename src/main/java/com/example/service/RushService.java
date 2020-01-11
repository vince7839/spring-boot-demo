package com.example.service;

import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RushService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    AtomicInteger c = new AtomicInteger();
    AtomicInteger e1 = new AtomicInteger();
    AtomicInteger e2 = new AtomicInteger();
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public synchronized void rush(Long id) throws Exception {
        Product p = productRepository.getOne(id);
        if (p == null){
            return;
        }

        Integer count = p.getCount();
        if (count != null && count > 0) {
            count--;
            System.out.println("count:"+count);
            p.setCount(count);
            try {
                productRepository.save(p);
            }catch (Exception e){
                System.out.println("exception 1:"+e1.incrementAndGet());
                throw new Exception();
            }
            //int i = 1/0;
//            Order order = new Order();
//            order.setProductId(p.getId());
//            order.setCount(1);
//
//            try {
//                orderRepository.save(order);
//            }catch (Exception e){
//                System.out.println("exception 2:"+e2.incrementAndGet());
//                throw new Exception();
//            }

            System.out.println("execute:" + c.incrementAndGet());
        }
    }
}
