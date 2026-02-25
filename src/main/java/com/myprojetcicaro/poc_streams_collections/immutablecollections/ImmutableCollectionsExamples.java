package com.myprojetcicaro.poc_streams_collections.immutablecollections;

import java.util.*;

public class ImmutableCollectionsExamples {

    public static void run() {
        listOfExample();
        setOfExample();
        mapOfExample();
        unmodifiableWrapperExample();
        defensiveCopyExample();
    }

    // List.of()
    private static void listOfExample() {
        System.out.println("\n=== List.of() ===");

        List<String> list = List.of("A", "B", "C");

        System.out.println(list);

        try {
            list.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("List is immutable!");
        }
    }

    //Set.of()
    private static void setOfExample() {
        System.out.println("\n===  Set.of() ===");

        Set<String> set = Set.of("X", "Y", "Z");
        System.out.println(set);
    }

    //  Map.of()
    private static void mapOfExample() {
        System.out.println("\n===  Map.of() ===");

        Map<String, Integer> map = Map.of(
                "A", 1,
                "B", 2
        );

        System.out.println(map);
    }

    // Collections.unmodifiable*
    private static void unmodifiableWrapperExample() {
        System.out.println("\n=== Unmodifiable Wrapper ===");

        List<String> mutable = new ArrayList<>();
        mutable.add("One");

        /**
         * Retorna uma visão imutável da lista especificada.
         * As operações de consulta na lista retornada "leem" a lista especificada,
         * e as tentativas de modificar a lista retornada, seja diretamente ou por
         * meio de seu iterador, resultam em uma UnsupportedOperationException.
         * A lista retornada será serializável se a lista especificada for serializável.
         * Da mesma forma, a lista retornada implementará RandomAccess se a lista especificada o fizer.
         *
         */
        List<String> unmodifiable = Collections.unmodifiableList(mutable);

        System.out.println(unmodifiable);

        mutable.add("Two");

        System.out.println("After modifying original: " + unmodifiable);
    }

    // Defensive Copy
    private static void defensiveCopyExample() {
        System.out.println("\n=== Defensive Copy ===");

        List<String> original = new ArrayList<>();
        original.add("Safe");

        List<String> copy = List.copyOf(original);

        original.add("Changed");

        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }
}