package com.myprojetcicaro.poc_streams_collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExamples {

    public static void run() {

        basicOperations();
        computeIfAbsentExample();
        mergeExample();
        iterationExample();
    }

    private static void basicOperations() {

        System.out.println("--- Basic HashMap Operations ---");

        Map<String, Integer> stock = new HashMap<>();

        stock.put("Notebook", 10);
        stock.put("Mouse", 50);
        stock.put("Keyboard", 30);

        System.out.println("Initial Map: " + stock);

        // get()
        System.out.println("Stock of Mouse: " + stock.get("Mouse"));

        // containsKey()
        System.out.println("Contains 'Notebook'? " + stock.containsKey("Notebook"));

        // remove()
        stock.remove("Keyboard");

        System.out.println("After removal: " + stock);
    }

    private static void computeIfAbsentExample() {

        System.out.println("\n--- computeIfAbsent Example ---");

        Map<String, Integer> stock = new HashMap<>();

        stock.computeIfAbsent("Monitor", key -> 20);
        stock.computeIfAbsent("Monitor", key -> 50);

        System.out.println(stock);
    }

    private static void mergeExample() {

        System.out.println("\n--- merge Example ---");

        Map<String, Integer> sales = new HashMap<>();

        sales.put("Notebook", 5);

        // soma vendas
        sales.merge("Notebook", 3, Integer::sum);

        // cria se não existir
        sales.merge("Mouse", 10, Integer::sum);

        System.out.println(sales);
    }

    private static void iterationExample() {

        System.out.println("\n--- Iterating HashMap ---");

        Map<String, Integer> stock = new HashMap<>();

        stock.put("Notebook", 10);
        stock.put("Mouse", 50);
        stock.put("Keyboard", 30);

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                               " | Value: " + entry.getValue());
        }
    }
}
