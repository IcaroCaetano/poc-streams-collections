package com.myprojetcicaro.poc_streams_collections.vector;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;

public class VectorExamples {

    public static void run() {
        basicExample();
        synchronizationExample();
        enumerationExample();
        iteratorExample();
    }

    private static void basicExample() {
        System.out.println("\n=== Vector Básico ===");

        Vector<String> vector = new Vector<>();

        vector.add("A");
        vector.add("B");
        vector.add("C");

        System.out.println(vector);
    }

    //Sincronização implícita
    private static void synchronizationExample() {
        System.out.println("\n==Thread-safe por padrão ===");

        Vector<Integer> vector = new Vector<>();

        vector.add(10);
        vector.add(20);

        // Métodos sincronizados internamente
        System.out.println("Size: " + vector.size());
    }

    // Enumeration (API antiga)
    private static void enumerationExample() {
        System.out.println("\n=== Enumeration (Legado) ===");

        Vector<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.add("C");

        Enumeration<String> enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    //Iterator moderno
    private static void iteratorExample() {
        System.out.println("\n==Iterator Moderno ===");

        Vector<String> vector = new Vector<>();
        vector.add("X");
        vector.add("Y");
        vector.add("Z");

        Iterator<String> iterator = vector.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}