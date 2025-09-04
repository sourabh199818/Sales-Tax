package org.example;

import org.example.entity.CartItem;
import org.example.entity.Product;
import org.example.services.InputParserService;
import org.example.services.ReceiptGenerator;
import org.example.taxCalculation.BasicSalesTaxCalculator;
import org.example.taxCalculation.ImportDutyTaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Inbuilt data to add
//        List<CartItem> basket1 = Arrays.asList(
//                new CartItem(1, new Product("book", new BigDecimal("12.49"), false, Product.Category.BOOK)),
//                new CartItem(1, new Product("music CD", new BigDecimal("14.99"), false, Product.Category.OTHER)),
//                new CartItem(1, new Product("chocolate bar", new BigDecimal("0.85"), false, Product.Category.FOOD))
//        );



        Scanner scanner = new Scanner(System.in);
        InputParserService parser = new InputParserService();

        System.out.println("Enter items in this format: quantity name at price");
        System.out.println( "Once completed please 'done' enter \n");

        List<CartItem> basket = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("done")) {
                break;
            }

            try {
                CartItem item = parser.parseLine(line);
                basket.add(item);
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }

        ReceiptGenerator generator = new ReceiptGenerator(
                Arrays.asList(new BasicSalesTaxCalculator(), new ImportDutyTaxCalculator())
        );

        System.out.println("\n-------------------------- Receipt --------------------------");
        generator.generate(basket).print();
        System.out.println("\n-------------------------- Receipt --------------------------");
    }
}