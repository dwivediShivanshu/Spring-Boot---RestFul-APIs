package com.example.crudapplication.model.receipt;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

// This annotation 
@Data
@Document(collection = "receipts")
public class Receipt {

    @Id
    private String id;
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<Item> items;
    private String total;

    public Receipt(String retailer, String purchaseDate, String purchaseTime, List<Item> items,
            String total) {
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
        this.total = total;
    }

}
