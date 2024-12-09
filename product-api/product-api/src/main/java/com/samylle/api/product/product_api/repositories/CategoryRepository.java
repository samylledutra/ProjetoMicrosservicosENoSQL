package com.samylle.api.product.product_api.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.samylle.api.product.product_api.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Page<Category> findAll(Pageable pageable); 
    List<Category> findByNomeContaining(String nome);
}
