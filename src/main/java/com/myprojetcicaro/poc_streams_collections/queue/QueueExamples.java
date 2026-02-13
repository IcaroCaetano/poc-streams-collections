package com.myprojetcicaro.poc_streams_collections.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExamples {

    public static void run() {

        fifoExample();
        priorityQueueExample();
    }

    // 🔹 Exemplo clássico FIFO (First In First Out)
    private static void fifoExample() {

        System.out.println("\n--- FIFO Queue (LinkedList) ---");

        Queue<String> queue = new LinkedList<>();

        queue.offer("Task 1");
        queue.offer("Task 2");
        queue.offer("Task 3");

        System.out.println("Peek (head): " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }

    // 🔹 Exemplo com prioridade
    private static void priorityQueueExample() {

        System.out.println("\n--- PriorityQueue Example ---");

        Queue<Task> priorityQueue =
                new PriorityQueue<>((t1, t2) ->
                        Integer.compare(t2.getPriority(), t1.getPriority()));

        priorityQueue.offer(new Task("Low priority task", 1));
        priorityQueue.offer(new Task("High priority task", 5));
        priorityQueue.offer(new Task("Medium priority task", 3));

        while (!priorityQueue.isEmpty()) {
            System.out.println("Processing: " + priorityQueue.poll());
        }
    }
}
