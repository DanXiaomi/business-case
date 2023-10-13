package com.business.demo.repository;

import com.business.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findByCode(String code);

    void deleteByCode(String code);
}
