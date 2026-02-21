package com.myprojetcicaro.poc_streams_collections.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * - Cada elemento (Node) guarda:
 * valor
 * referência para anterior
 * referência para próximo
 *
 * LinkedList é uma implementação de:
 * List
 * Deque
 * Queue
 */
public class LinkedListExamples {

    public static void run() {
        basicExample();
        addFirstLastExample();
        removeExample();
        stackExample();
        queueExample();
        iteratorExample();
    }

    private static void basicExample() {
        System.out.println("\n=== LinkedList Básico ===");

        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list);
    }

    // Add First / Last
    private static void addFirstLastExample() {
        System.out.println("\n== addFirst / addLast ===");

        LinkedList<String> list = new LinkedList<>();

        list.add("meio");
        list.addFirst("Inicio");
        list.addLast("Fim");

        System.out.println(list);
    }

    // Remove
    private static void removeExample() {
        System.out.println("\n=== Remoção ===");

        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.removeFirst();
        list.removeLast();

        System.out.println(list);
    }

    // Usando como Stack (Pilha)
    private static void stackExample() {
        System.out.println("\n=== Stack (LIFO) ===");

        LinkedList<Integer> stack = new LinkedList<>();

        /**
         * Adiciona um elemento à pilha representada por esta lista. Em outras palavras, insere o elemento
         * no início desta lista.
         * Este método é equivalente a addFirst.
         */
        stack.push(10);
        stack.push(20);
        stack.push(30);

        /**
         * Pops an element from the stack represented by this list. In other words, removes and returns the
         * first element of this list
         */
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack: " + stack);
    }

    // Usando como Queue (Fila)
    private static void queueExample() {
        System.out.println("\n===  Queue (FIFO) ===");

        LinkedList<String> queue = new LinkedList<>();

        // Adiciona o elemento especificado como o último elemento (cauda) desta lista.
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        // Poll -
        //Retrieves and removes the head (first element) of this list
        System.out.println("Poll: " + queue.poll());
        System.out.println("Queue: " + queue);

        /**
         * ===  Queue (FIFO) ===
         * Poll: A
         * Queue: [B, C]
         */
    }

    //  Iteração com ListIterator
    private static void iteratorExample() {
        System.out.println("\n== ListIterator ===");

        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            System.out.println("Next: " + iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println("Previous: " + iterator.previous());
        }
    }
}