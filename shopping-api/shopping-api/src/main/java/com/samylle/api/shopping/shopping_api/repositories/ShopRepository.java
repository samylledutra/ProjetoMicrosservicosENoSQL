package com.samylle.api.shopping.shopping_api.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.samylle.api.shopping.shopping_api.models.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {
    List<Shop> findByUserIdentifier(String userIdentifier);
    List<Shop> findByDateBetween(Date startDate, Date endDate);
    List<Shop> findByItemsProductIdentifier(String productIdentifier);
}
