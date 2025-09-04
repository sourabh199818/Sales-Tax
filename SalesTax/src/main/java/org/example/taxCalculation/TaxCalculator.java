package org.example.taxCalculation;

import org.example.entity.Product;
import java.math.BigDecimal;

public interface TaxCalculator {
//    Showing abstraction
    BigDecimal calculate(Product product);
}