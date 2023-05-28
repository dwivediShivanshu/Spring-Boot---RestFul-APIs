package com.example.crudapplication.service;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.crudapplication.model.receipt.Item;
import com.example.crudapplication.model.receipt.Receipt;

@Service
public class ReceiptService {

    public Double getPoints(Receipt receipt) {
        System.out.println("getPoints method");
        Double points = getPointsFromRetailerName(receipt.getRetailer())
                + getPointsFromTotal(receipt.getTotal())
                + getPointsFromItemDescription(receipt.getItems())
                + getPointsFromPurchaseDate(receipt.getPurchaseDate())
                + getPointsFromPurchasedTime(receipt.getPurchaseTime());
        return points;
    }

    private Double getPointsFromRetailerName(String name) {
        return (double) name.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetterOrDigit)
                .count();
    }

    private Double getPointsFromTotal(String total) {
        double rounded = Math.round(Double.parseDouble(total));
        double points = Double.compare(Double.parseDouble(total), rounded) == 0 ? 50 : 0;
        points += Double.parseDouble(total) % 0.25 == 0 ? 25 : 0;
        return points;
    }

    private Double getPointsFromItemDescription(List<Item> items) {
        return items.stream()
                .filter(item -> item.getShortDescription().trim().length() % 3 == 0)
                .map(item -> Math.ceil(item.getPrice() * 0.2))
                .reduce(0.0, Double::sum) + (items.size() / 2) * 5;
    }

    private Double getPointsFromPurchaseDate(String dateString) {

        String formatPattern = "yyyy-MM-dd"; // Format pattern matching the string

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        LocalDate date = LocalDate.parse(dateString, formatter);

        double p = date.getDayOfMonth() % 2 != 0 ? 6.0 : 0.0;
        return p;
    }

    private Double getPointsFromPurchasedTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(timeString, formatter);

        LocalTime startTime = LocalTime.of(14, 30); // 2:30 PM
        LocalTime endTime = LocalTime.of(16, 0); // 4:00 PM

        double p = time.isAfter(startTime) && time.isBefore(endTime) ? 10.0 : 0.0;
        return p;

    }
}
