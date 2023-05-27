package com.example.crudapplication.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudapplication.dao.ReceiptDAO;
import com.example.crudapplication.model.receipt.Receipt;
import com.example.crudapplication.service.ReceiptService;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptDAO receiptDAO;

    @Autowired
    private ReceiptService receiptService;

    @GetMapping("/")
    public String home() {
        return "Welcome home";
    }

    @GetMapping("/{id}/points")
    public Map<String, Double> getReceiptPoints(@PathVariable("id") String id) {
        Map<String, Double> json = new HashMap<String, Double>();
        try {
            Receipt receipt = receiptDAO.getReceiptById(id).get();
            json.put("points", receiptService.getPoints(receipt));
        } catch (Exception e) {
            // Depending on the use case either Throw error an error to the calling
            // microservice
            // or log it on Kibana.
        }
        return json;
    }

    @PostMapping(value = "/process", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> saveReceipt(@RequestBody Receipt receipt) {
        Map<String, String> json = new HashMap<String, String>();
        json.put("id", receiptDAO.saveReceipt(receipt));
        return json;
    }
}
