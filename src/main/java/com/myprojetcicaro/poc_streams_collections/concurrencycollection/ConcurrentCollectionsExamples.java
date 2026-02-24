package com.myprojetcicaro.poc_streams_collections.concurrencycollection;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentCollectionsExamples {

    public static void run() {
        concurrentHashMapExample();
        copyOnWriteListExample();
        concurrentQueueExample();
        blockingQueueExample();
        skipListExample();
    }

    // ConcurrentHashMap
    private static void concurrentHashMapExample() {
        System.out.println("\n===ConcurrentHashMap ===");

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("A", 1);
        map.put("B", 2);

        map.compute("A", (k, v) -> v + 10);

        System.out.println(map);
    }

    // CopyOnWriteArrayList
    private static void copyOnWriteListExample() {
        System.out.println("\n=== CopyOnWriteArrayList ===");

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");

        for (String s : list) {
            list.add("NEW"); // não gera ConcurrentModificationException
            System.out.println(s);
        }

        System.out.println("Final List: " + list);
    }

    // ConcurrentLinkedQueue
    private static void concurrentQueueExample() {
        System.out.println("\n=== ConcurrentLinkedQueue ===");

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        queue.add("Task1");
        queue.add("Task2");

        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }

    // BlockingQueue
    private static void blockingQueueExample() {
        System.out.println("\n=== BlockingQueue ===");

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        try {
            queue.put("Job1");
            queue.put("Job2");

            System.out.println("Took: " + queue.take());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ConcurrentSkipListMap
    private static void skipListExample() {
        System.out.println("\n=== ConcurrentSkipListMap ===");

        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        System.out.println("Ordered Map: " + map);
    }
}