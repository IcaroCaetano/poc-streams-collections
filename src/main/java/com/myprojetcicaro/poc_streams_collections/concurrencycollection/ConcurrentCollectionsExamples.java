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

        /**
         * ===ConcurrentHashMap ===
         * {A=11, B=2}
         */
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

        /**
         * === CopyOnWriteArrayList ===
         * A
         * B
         * Final List: [A, B, NEW, NEW]
         */
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

        /**
         * === ConcurrentLinkedQueue ===
         * Processing: Task1
         * Processing: Task2
         */
    }

    // BlockingQueue
    private static void blockingQueueExample() {
        System.out.println("\n=== BlockingQueue ===");

        /**
         * A Queue that additionally supports operations that wait for the queue to become
         * non-empty when retrieving an element, and wait for space to become available in
         * the queue when storing an element.
         * BlockingQueue methods come in four forms, with different ways of handling operations
         * that cannot be satisfied immediately, but may be satisfied at some point in the future:
         * one throws an exception, the second returns a special value (either null or false,
         * depending on the operation), the third blocks the current thread indefinitely until
         * the operation can succeed, and the fourth blocks for only a given maximum time limit
         * before giving up.
         */
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        try {
            queue.put("Job1");
            queue.put("Job2");

            /**
             * .take - Retrieves and removes the head of this queue,
             * waiting if necessary until an element becomes available.
             */
            System.out.println("Took: " + queue.take());

            /**
             * === BlockingQueue ===
             * Took: Job1
             */
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ConcurrentSkipListMap
    private static void skipListExample() {
        System.out.println("\n=== ConcurrentSkipListMap ===");

        /**
         * Uma implementação escalável e concorrente de ConcurrentNavigableMap.
         * O mapa é classificado de acordo com a ordem natural de suas chaves ou por
         * um Comparator fornecido no momento da criação do mapa, dependendo do construtor utilizado.
         * Esta classe implementa uma variante concorrente de SkipLists, fornecendo um
         * custo de tempo médio esperado de log(n) para as operações containsKey, get,
         * put e remove e suas variantes. As operações de inserção, remoção, atualização e
         * são executadas com segurança de forma concorrente por várias threads.
         */
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        System.out.println("Ordered Map: " + map);

        /**
         * === ConcurrentSkipListMap ===
         * Ordered Map: {1=A, 2=B, 3=C}
         */
    }
}