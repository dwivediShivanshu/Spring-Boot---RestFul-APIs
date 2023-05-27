package com.example.crudapplication.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crudapplication.model.receipt.Receipt;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {
    Optional<Receipt> findReceiptById(String id);
}