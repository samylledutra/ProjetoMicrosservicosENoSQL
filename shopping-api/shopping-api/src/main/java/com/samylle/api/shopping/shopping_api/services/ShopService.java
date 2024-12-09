package com.samylle.api.shopping.shopping_api.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samylle.api.shopping.shopping_api.models.Shop;
import com.samylle.api.shopping.shopping_api.repositories.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    public Shop findById(String id) {
        return shopRepository.findById(id).orElse(null);
    }

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> getByUser(String userIdentifier) {
        return shopRepository.findByUserIdentifier(userIdentifier);
    }

    public List<Shop> getByDate(Date startDate, Date endDate) {
        return shopRepository.findByDateBetween(startDate, endDate);
    }

    public List<Shop> findByProductIdentifier(String productIdentifier) {
        return shopRepository.findByItemsProductIdentifier(productIdentifier);
    }

    public List<Shop> getShopsByFilter(Date startDate, Date endDate, double minValue) {
        return shopRepository.findByDateBetween(startDate, endDate).stream()
            .filter(shop -> shop.getTotal() >= minValue)
            .collect(Collectors.toList());
    }

    public List<Shop> getReportByDate(Date startDate, Date endDate) {
        return shopRepository.findByDateBetween(startDate, endDate);
    }
}
