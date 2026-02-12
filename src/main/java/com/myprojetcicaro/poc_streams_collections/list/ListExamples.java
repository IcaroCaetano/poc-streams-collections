package com.myprojetcicaro.poc_streams_collections.list;

import com.myprojetcicaro.poc_streams_collections.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListExamples {

    public static List<Product> createProductList() {
        return new ArrayList<>(List.of(
                new Product(1L, "Notebook", "Electronics", new BigDecimal("3500"), true),
                new Product(2L, "Mouse", "Electronics", new BigDecimal("150"), true),
                new Product(3L, "Desk", "Furniture", new BigDecimal("900"), false),
                new Product(4L, "Chair", "Furniture", new BigDecimal("500"), true),
                new Product(5L, "Keyboard", "Electronics", new BigDecimal("300"), false)
        ));
    }

    public static void filterAvailableProducts(List<Product> products) {
        System.out.println();
        System.out.println("--- Available Products - Filter by Is Available ---");

        products.stream()
                .filter(Product::isAvailable)
                .forEach(System.out::println);
    }

    public static void filterByCategory(List<Product> products, String category) {
        System.out.println("--- Products by Category: " + category + " ---");

        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .forEach(System.out::println);
    }

    public static void getProductNames(List<Product> products) {
        System.out.println("--- Product Names ---");

        List<String> names = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());

        names.forEach(System.out::println);
    }

    public static void sortByPrice(List<Product> products) {
        System.out.println("\n--- Products Sorted by Price ---");

        products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }

    public static void calculateTotalPrice(List<Product> products) {
        System.out.println("\n--- Total Price of Products ---");

        BigDecimal total = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total: " + total);
    }
}
