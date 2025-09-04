package org.example.entity;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<String> lines = new ArrayList<>();
    private BigDecimal totalTaxes = BigDecimal.ZERO;
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public void addItem(CartItem item, BigDecimal taxedPrice, BigDecimal tax) {
        lines.add(item.getQuantity() + " " + item.getProduct().getName() + ": " + taxedPrice);
        totalTaxes = totalTaxes.add(tax);
        totalPrice = totalPrice.add(taxedPrice);
    }

    public void print() {
        lines.forEach(System.out::println);
        System.out.println("Sales Taxes: " + totalTaxes);
        System.out.println("Total: " + totalPrice);
    }
}
