package com.example.task.repository;

import com.example.task.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.task.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductTask extends MongoRepository<Product, String> {

    Optional<Product> findByName(String name);// Custom query method


}

