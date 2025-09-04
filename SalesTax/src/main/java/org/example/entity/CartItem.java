package org.example.entity;


public class CartItem {
    private final int quantity;
    private final Product product;

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() { return quantity; }
    public Product getProduct() { return product; }
}
