package org.example.taxCalculation;

import org.example.entity.Product;

import java.math.BigDecimal;

public class BasicSalesTaxCalculator implements TaxCalculator {
    private static final BigDecimal RATE = new BigDecimal("0.10");

    @Override
    public BigDecimal calculate(Product product) {
        if (product.getCategory() == Product.Category.OTHER) {
            return roundTax(product.getPrice().multiply(RATE));
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal roundTax(BigDecimal tax) {
        return new BigDecimal(Math.ceil(tax.doubleValue() * 20) / 20.0)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }


}
