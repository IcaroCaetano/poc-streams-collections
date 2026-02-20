package com.myprojetcicaro.poc_streams_collections.treemap;


import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExamples {

    public static void run() {
        basicOrderingExample();
        navigationExample();
        rangeExample();
        reverseOrderExample();
        objectRankingExample();
    }

    private static void basicOrderingExample() {
        System.out.println("\n=== Ordenação Natural ===");

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "Carlos");
        map.put(1, "Ana");
        map.put(2, "Bruno");

        map.forEach((key, value) ->
                System.out.println(key + " -> " + value));
    }

    private static void navigationExample() {
        System.out.println("\n=== Navegação ===");

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");

        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());
        System.out.println("Higher than 20: " + map.higherKey(20));
        System.out.println("Lower than 30: " + map.lowerKey(30));
        System.out.println("Ceiling 25: " + map.ceilingKey(25));
        System.out.println("Floor 25: " + map.floorKey(25));
    }

    private static void rangeExample() {
        System.out.println("\n=== SubMap (Range) ===");

        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 1; i <= 10; i++) {
            map.put(i, "Number " + i);
        }

        SortedMap<Integer, String> sub = map.subMap(3, 7);
        sub.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }

    private static void reverseOrderExample() {
        System.out.println("\n=== Ordem Reversa ===");

        TreeMap<Integer, String> reverseMap =
                new TreeMap<>(Comparator.reverseOrder());

        reverseMap.put(1, "One");
        reverseMap.put(2, "Two");
        reverseMap.put(3, "Three");

        reverseMap.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }

    private static void objectRankingExample() {
        System.out.println("\n=== Ranking com Objetos ===");

        TreeMap<Player, Integer> ranking = new TreeMap<>(
                Comparator.comparingInt(Player::getScore).reversed()
                          .thenComparing(Player::getName)
        );

        ranking.put(new Player("Ana", 1500), 1);
        ranking.put(new Player("Carlos", 2300), 2);
        ranking.put(new Player("Bruno", 1800), 3);

        ranking.forEach((player, position) ->
                System.out.println(position + "º - " + player));
    }

    static class Player {
        private final String name;
        private final int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() { return name; }
        public int getScore() { return score; }

        @Override
        public String toString() {
            return name + " (" + score + ")";
        }
    }
}