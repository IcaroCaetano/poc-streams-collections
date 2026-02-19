package com.myprojetcicaro.poc_streams_collections.listiterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExamples {

    public static void run() {

        forwardIteration();
        backwardIteration();
        modifyDuringIteration();
    }

    private static List<String> createList() {
        return new ArrayList<>(List.of("Java", "Spring", "Docker", "Kubernetes"));
    }

    // Percorrendo para frente
    private static void forwardIteration() {

        System.out.println("\n--- Forward Iteration ---");

        List<String> technologies = createList();

        ListIterator<String> iterator = technologies.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Percorrendo para trás
    private static void backwardIteration() {

        System.out.println("\n--- Backward Iteration ---");

        List<String> technologies = createList();

        ListIterator<String> iterator =
                technologies.listIterator(technologies.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    // Modificando durante a iteração
    private static void modifyDuringIteration() {

        System.out.println("\n--- Modifying During Iteration ---");

        List<String> technologies = createList();

        ListIterator<String> iterator = technologies.listIterator();

        while (iterator.hasNext()) {

            String tech = iterator.next();

            if (tech.equals("Docker")) {
                iterator.set("Docker Updated");
            }

            if (tech.equals("Spring")) {
                iterator.add("Hibernate");
            }
        }

        System.out.println("Final List: " + technologies);
    }
}
