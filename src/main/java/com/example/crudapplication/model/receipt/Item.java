package com.example.crudapplication.model.receipt;

import lombok.Data;

@Data
public class Item {

    private String shortDescription;
    private Float price;

    public Item(String shortDescription, Float price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }
}
