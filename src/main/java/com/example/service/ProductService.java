package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public void save(Product p){
        repository.save(p);
    }

    public Product findById(Long id){
        return repository.getOne(id);
    }
}
