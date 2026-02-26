# 🚀 Java Collections & Concurrency POC

This project is a comprehensive Proof of Concept (POC) covering:

- Java Collections Framework
- Generics & Wildcards
- Data Structures (List, Set, Map, Queue)
- Ordered Structures
- Concurrent Collections
- Immutability
- Thread-Safety Concepts
- Internal Behaviors & Performance Characteristics

The goal is to deeply understand how Java collections work internally and how to use them properly in real-world applications.

---

# 🧠 1️⃣ Collections Framework Overview

Hierarchy simplified:

Iterable  
└── Collection  
  ├── List  
  ├── Set  
  └── Queue

Map is NOT part of Collection hierarchy.

Core interfaces explored:

- Collection
- List
- Set
- Queue
- Map
- SortedSet
- NavigableSet

---

# 📦 2️⃣ List Implementations

## ArrayList

- Dynamic array
- Fast random access O(1)
- Slower insert/remove in middle O(n)

## LinkedList

- Doubly linked list
- Fast insertion/removal at edges O(1)
- Access by index O(n)
- Implements List, Queue, Deque

Modern recommendation:
Prefer ArrayDeque instead of LinkedList for Queue usage.

---

# 🔁 3️⃣ Queue & Deque

FIFO behavior (First In, First Out).

Main methods:

- offer()
- poll()
- peek()

Implementations covered:

- LinkedList
- ArrayDeque
- PriorityQueue

PriorityQueue:
- Orders elements by natural order or Comparator
- Not FIFO

---

# 🧩 4️⃣ Set Implementations

## HashSet

- No duplicates
- No order guarantee
- Backed by HashMap
- O(1) average performance

## LinkedHashSet

- Maintains insertion order
- Slightly more memory

## TreeSet

- Sorted automatically
- Backed by Red-Black Tree
- O(log n)
- Does NOT allow null
- Implements NavigableSet

Special methods:
- first()
- last()
- higher()
- lower()
- ceiling()
- floor()
- subSet()
- headSet()
- tailSet()

---

# 🗺 5️⃣ Map Implementations

## HashMap

- Key-value structure
- Allows one null key
- O(1) average

## LinkedHashMap

- Maintains insertion order
- Can be configured for access-order (LRU behavior)

## TreeMap

- Sorted by key
- Backed by Red-Black Tree
- O(log n)

## Hashtable

- Thread-safe (legacy)
- No null allowed
- Slower due to full synchronization

Comparison:

HashMap → modern default  
Hashtable → legacy  
ConcurrentHashMap → modern concurrent alternative

---

# 🔄 6️⃣ Iteration & ListIterator

Covered:

- for-each loop
- Iterator
- ListIterator

ListIterator allows:
- Forward iteration
- Backward iteration
- Element replacement
- Safe modification

---

# 🧬 7️⃣ Generics & Wildcards

Important concept:

Collection<?> is read-only (cannot add elements except null).

PECS Rule:

Producer Extends  
Consumer Super

Examples:

- ? extends T → read
- ? super T → write

Understanding type safety and capture of ? was demonstrated.

---

# ⚡ 8️⃣ Concurrent Collections (java.util.concurrent)

Why they exist:

- Better scalability
- Fine-grained locking
- Lock-free algorithms
- CAS (Compare-And-Swap)

Covered:

## ConcurrentHashMap
- Lock striping
- High performance
- Thread-safe without global locking

## CopyOnWriteArrayList
- Safe iteration during modification
- Good for many reads, few writes

## ConcurrentLinkedQueue
- Lock-free
- Non-blocking queue

## BlockingQueue
- put() blocks if full
- take() blocks if empty
- Used in Producer-Consumer patterns

## ConcurrentSkipListMap / Set
- Ordered concurrent structures
- Alternative to TreeMap/TreeSet in concurrent systems

---

# 🔐 9️⃣ Immutability

Key concept for thread safety and clean design.

## Factory Methods (Java 9+)

- List.of()
- Set.of()
- Map.of()

Characteristics:
- Truly immutable
- No null allowed
- Structural modification throws UnsupportedOperationException

## Unmodifiable Wrappers

Collections.unmodifiableList()

Important:
Wrapper is not deeply immutable.
If original changes, wrapper reflects changes.

## Defensive Copy

List.copyOf(original)

Creates independent immutable copy.

## Immutable Class Rules

- Class must be final
- Fields must be final
- No setters
- State defined in constructor

## Records (Java 16+)

Records are immutable by default.

---

# 🏎 1️⃣0️⃣ Performance Characteristics

| Structure | Order | Avg Complexity | Null |
|------------|--------|---------------|------|
| ArrayList | Insertion | O(1) access | Yes |
| LinkedList | Insertion | O(n) access | Yes |
| HashSet | No | O(1) | 1 |
| LinkedHashSet | Insertion | O(1) | 1 |
| TreeSet | Sorted | O(log n) | No |
| HashMap | No | O(1) | 1 key |
| TreeMap | Sorted | O(log n) | No |
| ConcurrentHashMap | No | O(1) | No null |
| CopyOnWriteArrayList | Insertion | O(n) write | Yes |

---

# 🧠 1️⃣1️⃣ Architectural Principles Applied

- Program to interfaces
- Prefer immutability
- Avoid legacy synchronized collections
- Choose structure based on use case
- Understand complexity before choosing

---

# 🏁 Final Conclusion

This POC covered:

✔ Core Collections  
✔ Ordered Structures  
✔ Generics  
✔ Iteration Models  
✔ Concurrent Collections  
✔ Blocking Structures  
✔ Immutability  
✔ Thread-Safety  
✔ Performance Characteristics  
✔ Internal Behaviors

This represents a strong foundation in Java Collections and Concurrency at a senior engineering level.

---

# 🎯 Next Evolution (Optional)

- Stream API deep dive
- ForkJoinPool
- Parallel Streams
- Custom Collectors
- Memory analysis
- JVM internals