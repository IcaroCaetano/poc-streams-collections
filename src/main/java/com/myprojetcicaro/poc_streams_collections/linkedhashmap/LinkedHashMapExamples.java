package com.myprojetcicaro.poc_streams_collections.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * - Mantém ordem de inserção
 * - Pode manter ordem de acesso
 * - Complexidade O(1) (como HashMap)
 * - Não é thread-safe
 */
public class LinkedHashMapExamples {

    public static void run() {
        insertionOrderExample();
        accessOrderExample();
        lruCacheExample();
    }


    private static void insertionOrderExample() {
        System.out.println("=== Ordem de Inserção ===");

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(3, "Carlos");
        map.put(1, "Ana");
        map.put(2, "Bruno");

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static void accessOrderExample() {
        System.out.println("\n=== Ordem de Acesso ===");

        LinkedHashMap<Integer, String> map =
                new LinkedHashMap<>(16, 0.75f, true);

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        // Acessando chave 1
        map.get(1);

        System.out.println("Após acessar chave 1:");

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static void lruCacheExample() {
        System.out.println("\n=== LRU Cache ===");

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        // Acessa 1 (agora 1 vira o mais recente)
        cache.get(1);

        // Adiciona novo item (remove o menos usado)
        cache.put(4, "D");

        cache.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}