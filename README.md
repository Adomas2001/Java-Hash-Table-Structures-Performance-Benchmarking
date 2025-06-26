# Java Hash Table Structures & Performance Benchmarking

This project focuses on implementing and evaluating custom hash table data structures using chaining (`HashMap`) and open addressing (`HashMapOa`) methods in Java. It also includes benchmarking against the built-in `java.util.HashMap` using JMH (Java Microbenchmark Harness).

---

## 📚 Overview

Lab 3 consists of two main parts:

---

## ✅ Mandatory Part

### 🔧 Core Implementation

Implemented methods in both `HashMap<K, V>` and `HashMapOa<K, V>`:

- `remove(K key)`: Removes an entry by key.
- `containsValue(Object value)`: Checks if a given value exists.
- `replace(K key, V oldValue, V newValue)`: Updates the value for a key only if the current value matches the old one.

These operations demonstrate different collision-handling strategies:
- `HashMap`: Chaining (linked lists)
- `HashMapOa`: Open addressing (linear/quadratic probing)

### ⚡ Performance Testing with JMH

Benchmarked method pairs such as:
- `remove()`
- `put()`
- `containsValue()`
- Compared across:
  - `HashMap` vs `HashMapOa`
  - Custom implementations vs Java's built-in `HashMap`

Benchmarks included:
- Time complexity analysis
- Test machine specifications (CPU, memory)
- Runtime vs input size graphs
- Interpretation of empirical vs theoretical complexities

---

## 🧪 Optional Extensions

### 📋 Additional Functionalities

Implementations of:
- `keySet()` – Retrieve all keys
- `values()` – List all values
- `getNumberOfCollisions()` – Total collisions in current map
- `averageChainSize()` – Average chain length (chaining only)
- `replaceAll(V oldValue, V newValue)` – Replace all occurrences of a value
- `putIfAbsent(K key, V value)` – Conditional insert

---

## 📊 Sample Graph

_(Insert your benchmark graph here for visual comparison of execution times)_

---

## 🛠️ Technologies

- Java 17+
- JMH for benchmarking
- IntelliJ / NetBeans IDE

---
