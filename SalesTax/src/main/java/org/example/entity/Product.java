package org.example.entity;


import java.math.BigDecimal;

public class Product {

//   show encapsulation
    private final String name;
    private final BigDecimal price;
    private final boolean imported;
    private final Category category;

    public enum Category {
        BOOK, FOOD, MEDICAL, OTHER
    }

    public Product(String name, BigDecimal price, boolean imported, Category category) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public boolean isImported() {
        return imported;
    }
    public Category getCategory() {
        return category;
    }
}
