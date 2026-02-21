package com.myprojetcicaro.poc_streams_collections.enummap;

import java.util.EnumMap;
import java.util.Map;

/**
 * <ul>
 *  <li>Extremamente rápido</li>
 *  <li>Muito eficiente em memória</li>
 *  <li>Mais rápido que HashMap quando a chave é enum</li>
 *  <li>Só aceita enum como chave</li>
 *  <li>Não permite chave null</li>
 *  <li>Permite value null</li>
 * </ul>
 */
public class EnumMapExamples {

    public static void run() {
        basicExample();
        nullValueExample();
        iterationExample();
        realUseCaseExample();
    }

    enum OrderStatus {
        NEW,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

    private static void basicExample() {
        System.out.println("\n== EnumMap Básico ===");

        EnumMap<OrderStatus, String> map =
                new EnumMap<>(OrderStatus.class);

        map.put(OrderStatus.NEW, "Pedido criado");
        map.put(OrderStatus.SHIPPED, "Pedido enviado");

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static void nullValueExample() {
        System.out.println("\n=== Valor null ===");

        EnumMap<OrderStatus, String> map =
                new EnumMap<>(OrderStatus.class);

        map.put(OrderStatus.NEW, null);

        System.out.println("NEW -> " + map.get(OrderStatus.NEW));
    }

    // Iteração ordenada (ordem natural do enum)
    private static void iterationExample() {
        System.out.println("\n== Ordem Natural do Enum ===");

        EnumMap<OrderStatus, Integer> map =
                new EnumMap<>(OrderStatus.class);

        map.put(OrderStatus.SHIPPED, 3);
        map.put(OrderStatus.NEW, 1);
        map.put(OrderStatus.DELIVERED, 4);

        map.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }

    private static void realUseCaseExample() {
        System.out.println("\n== Caso Real: Contador ===");

        EnumMap<OrderStatus, Integer> counter =
                new EnumMap<>(OrderStatus.class);

        for (OrderStatus status : OrderStatus.values()) {
            counter.put(status, 0);
        }

        // Simulando eventos
        increment(counter, OrderStatus.NEW);
        increment(counter, OrderStatus.NEW);
        increment(counter, OrderStatus.SHIPPED);

        counter.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }

    private static void increment(
            EnumMap<OrderStatus, Integer> map,
            OrderStatus status) {

        map.put(status, map.get(status) + 1);
    }
}