package com.example.ltsp_kt5;

import java.util.ArrayList;

public class Product {
    private String name, unit;
    private  Number price;
    private static ArrayList<Product> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(String name, String unit, Number price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public static ArrayList<Product> getProducts() {
        if (products.size() == 0) {
            products.add(new Product("Socola Kitkat", "Gói", 4000));
            products.add(new Product("Keo", "Gói", 4100));
            products.add(new Product("Mi", "Gói", 4300));
            products.add(new Product("Socola Kitkat", "Gói", 5000));
        }

        return products;
    }
}
