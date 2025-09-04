package org.example.services;

import org.example.entity.CartItem;
import org.example.entity.Receipt;
import org.example.taxCalculation.TaxCalculator;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptGenerator {
    private final List<TaxCalculator> calculators;

    public ReceiptGenerator(List<TaxCalculator> calculators) {
        this.calculators = calculators;
    }

    public Receipt generate(List<CartItem> items) {
        Receipt receipt = new Receipt();
        for (CartItem item : items) {
            BigDecimal itemTax = BigDecimal.ZERO;
            for (TaxCalculator calc : calculators) {
                itemTax = itemTax.add(calc.calculate(item.getProduct()));
            }
            BigDecimal taxedPrice = item.getProduct().getPrice().add(itemTax);
            taxedPrice = taxedPrice.multiply(new BigDecimal(item.getQuantity()));

            receipt.addItem(item, taxedPrice, itemTax.multiply(new BigDecimal(item.getQuantity())));
        }
        return receipt;
    }
}
