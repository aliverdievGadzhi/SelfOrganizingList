package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Transpose List Comprehensive Tests")
class TransposeListTest {

    private SelfOrganizingList<String> list;

    @BeforeEach
    void setUp() {
        list = new TransposeListIterative<>(new String[]{"Java", "Gradle", "Git"});
    }

    @Test
    @DisplayName("size() should return correct size")
    void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("add() should put element at the end")
    void testAdd() {
        list.add("Docker");
        assertEquals(4, list.size());
    }

    @Test
    @DisplayName("contains() -> Transpose Strategy: should swap element with predecessor")
    void testTransposeStrategy() {
        boolean found = list.contains("Git");
        assertTrue(found);


        assertEquals("Java", list.get(0));
        assertEquals("Git", list.get(1));
    }

    @Test
    @DisplayName("remove(T key) should delete item by value")
    void testRemoveByKey() {
        list.remove("Gradle");
        assertEquals(2, list.size());
        assertFalse(list.contains("Gradle"));
    }

    @Test
    @DisplayName("remove(int index) should delete item by its position")
    void testRemoveByIndex() {
        String removed = list.remove(1);
        assertEquals("Gradle", removed);
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("reverse() should invert the list")
    void testReverse() {
        list.reverse();
        assertEquals("Git", list.get(0));
    }

    @Test
    @DisplayName("Iterator: should correctly traverse all elements in order")
    void testIteratorTraversal() {
        Iterator<String> iterator = list.iterator();

        // Проверяем последовательный обход элементов
        assertTrue(iterator.hasNext());
        assertEquals("Java", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Gradle", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Git", iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("remove(T key) should throw NoSuchElementException when key is not found")
    void testRemoveMissingKeyThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            list.remove("Python");
        });
    }

    @Test
    @DisplayName("Iterator: should throw NoSuchElementException when calling next() on empty iterator")
    void testIteratorThrowsExceptionAtTheEnd() {
        Iterator<String> iterator = list.iterator();


        iterator.next();
        iterator.next();
        iterator.next();

        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }
}