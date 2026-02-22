package com.myprojetcicaro.poc_streams_collections.treeset;

import java.util.*;


/**
 * Não permite elementos duplicados
 * Mantém os elementos ordenados automaticamente
 * Usa internamente uma Red-Black Tree
 * Complexidade: O(log n) para add, remove e contains
 */
public class TreeSetExamples {

    public static void run() {
        naturalOrdering();
        customComparator();
        navigableMethods();
        subsetExamples();
    }

    // Ordenação Natural
    private static void naturalOrdering() {
        System.out.println("\n== Natural Ordering ===");

        TreeSet<String> set = new TreeSet<>();

        set.add("Banana");
        set.add("Apple");
        set.add("Orange");
        set.add("Apple");

        System.out.println("Ordered Set: " + set);
    }

    //Comparator Customizado
    private static void customComparator() {
        System.out.println("\n=== Custom Comparator (Reverse Order) ===");

        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        set.add(10);
        set.add(5);
        set.add(20);

        System.out.println("Reverse Ordered: " + set);
    }

    // Métodos Navigable
    private static void navigableMethods() {
        System.out.println("\n== Navigable Methods ===");

        TreeSet<Integer> set = new TreeSet<>();

        set.addAll(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());
        System.out.println("Higher than 30: " + set.higher(30));
        System.out.println("Lower than 30: " + set.lower(30));
        System.out.println("Ceiling 25: " + set.ceiling(25));
        System.out.println("Floor 25: " + set.floor(25));
    }

    // Subsets
    private static void subsetExamples() {
        System.out.println("\n=== Subsets ===");

        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("HeadSet (<30): " + set.headSet(30));
        System.out.println("TailSet (>=30): " + set.tailSet(30));
        System.out.println("SubSet (20 to 40): " + set.subSet(20, 40));
    }
}