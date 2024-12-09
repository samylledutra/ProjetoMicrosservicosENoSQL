package com.samylle.api.shopping.shopping_api.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shop")
public class Shop {
    @Id
    private String id;
    private String userIdentifier;
    private Date date;
    private List<Item> items;
    private double total;

}
