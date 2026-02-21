package com.myprojetcicaro.poc_streams_collections.enumset;

import java.util.EnumSet;

public class EnumSetExamples {

    public static void run() {
        basicExample();
        allOfExample();
        rangeExample();
        complementExample();
        removeExample();
    }

    enum Permission {
        READ,
        WRITE,
        EXECUTE,
        DELETE,
        SHARE
    }

    private static void basicExample() {
        System.out.println("\n===EnumSet Básico ===");

        EnumSet<Permission> permissions =
                EnumSet.of(Permission.READ, Permission.WRITE);

        permissions.forEach(System.out::println);
    }

    private static void allOfExample() {
        System.out.println("\n=== EnumSet.allOf ===");

        EnumSet<Permission> all =
                EnumSet.allOf(Permission.class);

        all.forEach(System.out::println);
    }

    private static void rangeExample() {
        System.out.println("\n=== EnumSet.range ===");

        EnumSet<Permission> range =
                EnumSet.range(Permission.READ, Permission.DELETE);

        range.forEach(System.out::println);
    }

    private static void complementExample() {
        System.out.println("\n=== EnumSet.complementOf ===");

        EnumSet<Permission> basic =
                EnumSet.of(Permission.READ, Permission.WRITE);

        EnumSet<Permission> complement =
                EnumSet.complementOf(basic);

        complement.forEach(System.out::println);
    }

    private static void removeExample() {
        System.out.println("\n=== Remove ===");

        EnumSet<Permission> permissions =
                EnumSet.allOf(Permission.class);

        permissions.remove(Permission.DELETE);

        permissions.forEach(System.out::println);
    }
}