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

        /**
         * Uma tabela hash que suporta concorrência total em consultas e alta
         * concorrência esperada em atualizações. Esta classe obedece à mesma
         * especificação funcional que `Hashtable` e inclui versões dos métodos
         * correspondentes a cada método de `Hashtable`. No entanto, embora todas
         * as operações sejam thread-safe, as operações de consulta não envolvem
         * bloqueio e não há suporte para bloquear a tabela inteira de forma a
         * impedir todo o acesso. Esta classe é totalmente interoperável com `Hashtable`
         * em programas que dependem de sua segurança de threads, mas não de seus
         * detalhes de sincronização.
         */
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("A", 1);
        map.put("B", 2);

        /**
         * Tenta calcular um mapeamento para a chave especificada e seu valor mapeado atual
         * (ou nulo se não houver mapeamento atual). Toda a invocação do método é realizada
         * atomicamente. A função fornecida é invocada exatamente uma vez por invocação deste
         * método. Algumas tentativas de atualização neste mapa por outras threads podem ser
         * bloqueadas enquanto o cálculo estiver em andamento, portanto, o cálculo deve ser
         * curto e simples.
         * A função de remapeamento não deve modificar este mapa durante o cálculo.
         *
         * Substituições:
         * compute na interface ConcurrentMap
         * compute na interface Map
         *
         * Parâmetros:
         * chave – chave à qual o valor especificado será associado
         * funçãoDeRemapeamento – a função para calcular um valor
         *
         * Retorno:
         * o novo valor associado à chave especificada ou nulo se não houver chave.
         */
        map.compute("A", (k, v) -> v + 10);

        System.out.println(map);
    }

    // CopyOnWriteArrayList
    private static void copyOnWriteListExample() {
        System.out.println("\n=== CopyOnWriteArrayList ===");

        /**
         * Normalmente, isso seria muito custoso, mas pode ser mais eficiente do que
         * alternativas quando as operações de percurso superam em muito as mutações,
         * e é útil quando você não pode ou não quer sincronizar os percursos, mas precisa
         * evitar interferências entre threads concorrentes. O método de iterador no estilo
         * "snapshot" usa uma referência ao estado do array no momento em que o iterador foi
         * criado. Esse array nunca muda durante a vida útil do iterador, portanto, a
         * interferência é impossível e o iterador tem a garantia de não lançar uma exceção
         * `ConcurrentModificationException`. O iterador não refletirá adições, remoções ou
         * alterações na lista desde a sua criação.
         */
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");

        for (String s : list) {
            list.add("NEW");
            System.out.println(s);
        }

        System.out.println("Final List: " + list);
    }

    // ConcurrentLinkedQueue
    private static void concurrentQueueExample() {
        System.out.println("\n=== ConcurrentLinkedQueue ===");

        /**
         * Uma fila thread-safe ilimitada baseada em nós encadeados. Esta fila ordena os
         * elementos em ordem FIFO (primeiro a entrar, primeiro a sair). O primeiro elemento
         * da fila é aquele que está na fila há mais tempo. O último elemento da fila é aquele
         * que está na fila há menos tempo. Novos elementos são inseridos no último elemento da
         * fila, e as operações de recuperação da fila obtêm os elementos do primeiro elemento.
         * Uma `ConcurrentLinkedQueue` é uma escolha apropriada quando muitas threads compartilharão
         * o acesso a uma coleção comum. Como a maioria das implementações de coleções concorrentes,
         * esta classe não permite o uso de elementos nulos.
         */
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