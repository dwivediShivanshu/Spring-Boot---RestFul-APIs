package com.example.crudapplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudapplication.model.receipt.Receipt;

@Repository
public class ReceiptDAO {

    @Autowired
    private ReceiptRepository receiptRepository;

    public Optional<Receipt> getReceiptById(String id) {
        return receiptRepository.findReceiptById(id);
    }

    public String saveReceipt(Receipt receipt) {
        String id = receiptRepository.insert(receipt).getId();
        return id;
    }
}
