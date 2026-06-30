# Self-Organizing Linked List Library

A custom, high-performance Java implementation of **Self-Organizing Singly Linked Lists** featuring both **Move-To-Front (MTF)** and **Transpose** strategies. This data structure dynamically reorders its elements based on access frequency to optimize subsequent lookup times, effectively leveraging the **Pareto Principle (80/20 rule)**.

---

##  Features

* **Dynamic Management:** Complete support for core collection operations: `add(T element)`, `get(int index)`, `remove(T element)`, and index-based deletion via `remove(int index)`.
* **Self-Organization Strategies:**
  * **Move-To-Front (MTF):** Shifts the accessed node directly to the head of the list. Ideal for scenarios with high temporal locality.
  * **Transpose:** Swaps the accessed node with its immediate predecessor. A conservative approach that prevents rare queries from disrupting the list layout.
* **Java Collections Integration:** Fully implements the `Iterable<T>` interface, enabling modern traversal using standard `for-each` loops.
* **Robust Test Coverage:** Rigorously verified using modern JUnit 5 suite, covering edge cases, iteration behaviors, and exception handling.

---

##  Architecture Overview

The project adheres strictly to OOP design principles, completely decoupling structural node representation from behavioral reordering algorithms:

* `ListItem<T>`: The foundational node building block handling low-level pointer mechanics (`next`).
* `SelfOrganizingList<T>`: The public contract interface extending `Iterable<T>`.
* `AbstractSelfOrganizingList<T>`: Abstract base layer handling shared collection behavior (`add`, `remove`, `size`, `reverse`, and `Iterator` implementation).
* `MoveToFrontListIterative<T>` & `TransposeListIterative<T>`: Concrete strategy implementations overriding the core `contains(T element)` search logic and implementing positional element retrieval via `get(int index)`.

---

##  Running Tests via IntelliJ IDEA (Gradle Tool Window)

To easily run the comprehensive test suite using the IntelliJ IDEA graphical interface, follow these steps:

1. Open the **Gradle Tool Window** on the right side of your IDE (the elephant icon 🐘).
2. Expand the project tree: `SelfOrganizingList` -> `Tasks` -> `verification`.
3. Double-click the **`test`** task to execute all tests.
4. Alternatively, you can run tests directly from `src/test/java` classes by clicking the green play arrows next to the class definitions.

---

##  Usage Example

Below is a complete demonstration illustrating how both the Transpose and Move-To-Front strategies handle sequential data access inside the `Main.java` file:

```java
package org.example;

public class Main {
    public static void main(String[] args) {
        
        // --- Transpose Strategy ---
        System.out.println("=== TRANSPOSE STRATEGY ===");
        SelfOrganizingList<String> techStackTranspose = new TransposeListIterative<>(
            new String[]{"Java", "Gradle", "Git", "Docker"}
        );
        
        System.out.println("Initial:      " + techStackTranspose); // Java -> Gradle -> Git -> Docker
        techStackTranspose.contains("Git");
        System.out.println("After search: " + techStackTranspose); // Java -> Git -> Gradle -> Docker

        System.out.println("\n" + "=".repeat(50) + "\n");

        // --- Move-To-Front (MTF) Strategy ---
        System.out.println("=== MOVE-TO-FRONT (MTF) STRATEGY ===");
        SelfOrganizingList<String> techStackMTF = new MoveToFrontListIterative<>(
            new String[]{"Java", "Gradle", "Git", "Docker"}
        );
        
        System.out.println("Initial:      " + techStackMTF); // Java -> Gradle -> Git -> Docker
        techStackMTF.contains("Git");
        System.out.println("After search: " + techStackMTF); // Git -> Java -> Gradle -> Docker
    }
}