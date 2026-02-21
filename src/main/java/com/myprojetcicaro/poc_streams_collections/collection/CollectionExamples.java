package com.myprojetcicaro.poc_streams_collections.collection;

import java.util.*;

public class CollectionExamples {

    public static void run() {
        basicOperations();
        bulkOperations();
        iterationExample();
        toArrayExample();
        polymorphismExample();
    }

    // Operações básicas
    private static void basicOperations() {
        System.out.println("\n== Operações Básicas ===");

        Collection<String> collection = new ArrayList<>();

        collection.add("A");
        collection.add("B");
        collection.add("C");

        System.out.println("Size: " + collection.size());
        System.out.println("Contains B: " + collection.contains("B"));

        collection.remove("B");
        System.out.println("After remove: " + collection);
    }

    // Operações em massa
    private static void bulkOperations() {
        System.out.println("\n=== Bulk Operations ===");

        Collection<String> col1 = new ArrayList<>();
        col1.add("A");
        col1.add("B");

        Collection<String> col2 = new ArrayList<>();
        col2.add("B");
        col2.add("C");

        col1.addAll(col2);
        System.out.println("After addAll: " + col1);

        col1.removeAll(col2);
        System.out.println("After removeAll: " + col1);

        col1.add("B");
        col1.add("C");

        col1.retainAll(col2);
        System.out.println("After retainAll: " + col1);
    }

    // Iteração
    private static void iterationExample() {
        System.out.println("\n== Iteração ===");

        Collection<String> collection = new LinkedList<>();

        collection.add("X");
        collection.add("Y");
        collection.add("Z");

        for (String s : collection) {
            System.out.println(s);
        }
    }

    // toArray
    private static void toArrayExample() {
        System.out.println("\n=== toArray ===");

        Collection<String> collection = new HashSet<>();
        collection.add("One");
        collection.add("Two");

        Object[] array = collection.toArray();

        for (Object obj : array) {
            System.out.println(obj);
        }
    }

    //  Polimorfismo
    private static void polymorphismExample() {
        System.out.println("=== Polimorfismo ===");

        printCollection(new ArrayList<>(), "Test");
        printCollection(new HashSet<>(), "Test");
        printCollection(new LinkedList<>(), "Test");
    }

    private static <T> void printCollection(Collection<T> collection, T element) {
        collection.add(element);
        System.out.println(collection);
    }
}