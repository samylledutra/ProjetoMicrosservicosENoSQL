package com.samylle.api.product.product_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.samylle.api.product.product_api.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByProductIdentifier(String productIdentifier);
    List<Product> findByCategoria_Id(String categoryId);
}
