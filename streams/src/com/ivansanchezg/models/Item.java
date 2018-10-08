package com.ivansanchezg.models;

public class Item {

    private String name;
    private int quantity;
    private float price;

    public Item(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQueantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public int decreaseQuantity() {
        this.quantity--;
        return quantity;
    }

    public int increaseQuantity() {
        this.quantity++;
        return quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        if (price >= 0f) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "(name = " + name + ", price = " + price + ", quantity = " + quantity + ")";
    }

}
