package com.myprojetcicaro.poc_streams_collections.hashtable;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExamples {

    public static void run() {

        basicOperations();
        nullRestrictionExample();
        iterationExample();
        synchronizationExample();
    }

    private static void basicOperations() {

        System.out.println("--- Basic Hashtable Operations ---");

        Hashtable<String, Integer> table = new Hashtable<>();

        table.put("Notebook", 10);
        table.put("Mouse", 50);
        table.put("Keyboard", 30);

        System.out.println("Hashtable: " + table);
        System.out.println("Stock of Mouse: " + table.get("Mouse"));
    }

    private static void nullRestrictionExample() {

        System.out.println("\n--- Null Restriction Example ---");

        Hashtable<String, String> table = new Hashtable<>();

        table.put("Key1", "Value1");

        try {
            table.put(null, "Value");
        } catch (NullPointerException e) {
            System.out.println("Null key not allowed!");
        }

        try {
            table.put("Key2", null);
        } catch (NullPointerException e) {
            System.out.println("Null value not allowed!");
        }
    }

    private static void iterationExample() {

        System.out.println("\n--- Iteration Example ---");

        Hashtable<String, String> table = new Hashtable<>();

        table.put("ADMIN", "Full Access");
        table.put("USER", "Limited Access");

        for (Map.Entry<String, String> entry : table.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                               " | Value: " + entry.getValue());
        }
    }

    private static void synchronizationExample() {

        System.out.println("\n--- Synchronization Info ---");

        System.out.println("Hashtable methods are synchronized.");
        System.out.println("It is thread-safe by default.");
        System.out.println("But performance is slower than HashMap.");
    }
}
