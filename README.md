# Poc Streams Collections

## 📌 1️⃣ What is Queue<String>?

Queue is an interface from the package:

````
java.util.Queue
````

It defines the behavior of a queue (FIFO — First In, First Out).

When you write:
````
Queue<String>
````

You are saying:

I want to work with the contract of a queue that stores Strings.

You are programming against the interface, not against the implementation.

This is good design practice.


## 📌 2️⃣ What is new LinkedList<>()?

LinkedList is a concrete class that:

- Implements List

- Implements Deque

- Implements Queue

In other words, it can function as:

- List

- Queue

- Stack

Here you are using it as a Queue.
