package com.myprojetcicaro.poc_streams_collections.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetExamples {

    public static void run() {

        basicOperations();
        noDuplicateExample();
        containsExample();
        removeExample();
    }

    private static void basicOperations() {

        System.out.println("\n--- Basic HashSet Operations ---");

        Set<String> technologies = new HashSet<>();

        technologies.add("Java");
        technologies.add("Spring");
        technologies.add("Docker");
        technologies.add("Java");

        System.out.println("Set content: " + technologies);
    }

    private static void noDuplicateExample() {

        System.out.println("\n--- No Duplicate Example ---");

        Set<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(10);
        numbers.add(30);

        System.out.println("Numbers: " + numbers);
    }

    private static void containsExample() {

        System.out.println("\n--- contains() Example ---");

        Set<String> names = new HashSet<>();

        names.add("Icaro");
        names.add("Maria");

        System.out.println("Contains Icaro? " + names.contains("Icaro"));
        System.out.println("Contains João? " + names.contains("João"));
    }

    private static void removeExample() {

        System.out.println("\n--- remove() Example ---");

        Set<String> roles = new HashSet<>();

        roles.add("ADMIN");
        roles.add("USER");

        roles.remove("USER");

        System.out.println("After removal: " + roles);
    }
}
