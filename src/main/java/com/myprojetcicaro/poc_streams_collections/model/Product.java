package com.myprojetcicaro.poc_streams_collections.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private boolean available;

    public Product(Long id, String name, String category, BigDecimal price, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
