package com.myprojetcicaro.poc_streams_collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExamples {

    public static void run() {

        Map<Long, User> users = createUserMap();

        printAll(users);
        filterByRole(users, "ADMIN");
        calculateTotalSalary(users);
        groupByRole(users);
        increaseSalary(users);
    }

    private static Map<Long, User> createUserMap() {

        Map<Long, User> users = new HashMap<>();

        users.put(1L, new User(1L, "Icaro", "ADMIN", 10000));
        users.put(2L, new User(2L, "Mary", "USER", 5000));
        users.put(3L, new User(3L, "John", "ADMIN", 12000));
        users.put(4L, new User(4L, "Anna", "USER", 4500));

        return users;
    }

    private static void printAll(Map<Long, User> users) {
        System.out.println("\n--- All Users ---");

        users.forEach((id, user) -> System.out.println("Key: " + id + " | Value: " + user));
    }

    private static void filterByRole(Map<Long, User> users, String role) {
        System.out.println("\n--- Users with role: " + role + " ---");

        users.values().stream()
                .filter(user -> user.getRole().equalsIgnoreCase(role))
                .forEach(System.out::println);
    }

    private static void calculateTotalSalary(Map<Long, User> users) {
        System.out.println("\n--- Total Salary ---");

        double total = users.values().stream()
                .mapToDouble(User::getSalary)
                .sum();

        System.out.println("Total Salary: " + total);
    }

    private static void groupByRole(Map<Long, User> users) {
        System.out.println("\n--- MAP - Grouped by Role ---");

        Map<String, Long> grouped = users.values().stream()
                .collect(
                        Collectors.groupingBy(
                                /**
                                 * Collectors.counting()
                                 * Para cada grupo criado, conte quantos elementos existem.
                                 * Ex:  ADMIN
                                 *      USER
                                 *      ADMIN
                                 *      USER
                                 *      USER
                                 *
                                 * O resultado será:
                                 *    ADMIN = 2,
                                 *    USER = 3
                                 */
                                User::getRole, Collectors.counting()
                        )
                );

        grouped.forEach((role, count) -> System.out.println(role + " -> " + count));

        /**
         * Saida:
         *
         *
         */
    }

    private static void increaseSalary(Map<Long, User> users) {
        System.out.println("\n--- Salary Increased by 10% ---");

        Map<Long, User> updated = users.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            User user = entry.getValue();
                            return new User(
                                    user.getId(),
                                    user.getName(),
                                    user.getRole(),
                                    user.getSalary() * 1.10
                            );
                        }
                ));

        updated.forEach((id, user) ->
                System.out.println("Key: " + id + " | Value: " + user));
    }
}
