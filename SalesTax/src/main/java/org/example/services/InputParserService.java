package org.example.services;

import org.example.entity.CartItem;
import org.example.entity.Product;

import java.math.BigDecimal;

public class InputParserService {

    public CartItem parseLine(String line) {

        String[] parts = line.split(" at ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format, must contain 'at'");
        }

        BigDecimal price = new BigDecimal(parts[1].trim());
        String[] words = parts[0].trim().split(" ", 2);

        int quantity = Integer.parseInt(words[0]);
        String name = words[1];

        boolean imported = name.toLowerCase().contains("imported");
        Product.Category category = categorizeProduct(name);

        Product product = new Product(name, price, imported, category);
        return new CartItem(quantity, product);
    }

    private Product.Category categorizeProduct(String name) {
        String lower = name.toLowerCase();
        if (lower.contains("book")) return Product.Category.BOOK;
        if (lower.contains("chocolate")) return Product.Category.FOOD;
        if (lower.contains("pill")) return Product.Category.MEDICAL;
        return Product.Category.OTHER;
    }
}
