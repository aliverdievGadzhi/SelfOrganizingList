package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Move-To-Front List Comprehensive Tests")
class MoveToFrontListTest {

    private SelfOrganizingList<String> list;

    @BeforeEach
    void setUp() {

        list = new MoveToFrontListIterative<>(new String[]{"Java", "Gradle", "Git"});
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

        Iterator<String> it = list.iterator();
        it.next(); it.next(); it.next();
        assertEquals("Docker", it.next());
    }

    @Test
    @DisplayName("contains() -> MTF Strategy: should move element to index 0")
    void testMoveToFrontStrategy() {
        boolean found = list.contains("Git");
        assertTrue(found);
        assertEquals("Git", list.get(0));
    }

    @Test
    @DisplayName("remove(T key) should delete item by value")
    void testRemoveByKey() {
        list.remove("Gradle");
        assertEquals(2, list.size());
        assertFalse(list.contains("Gradle"));
    }

    @Test
    @DisplayName("remove(T key) should throw exception if key not found")
    void testRemoveByKeyException() {
        assertThrows(NoSuchElementException.class, () -> list.remove("Python"));
    }

    @Test
    @DisplayName("remove(int index) should delete item by its position")
    void testRemoveByIndex() {
        String removed = list.remove(1);
        assertEquals("Gradle", removed);
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("remove(int index) should throw exception for invalid index")
    void testRemoveByIndexException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(99));
    }

    @Test
    @DisplayName("reverse() should invert the list")
    void testReverse() {
        list.reverse();
        assertEquals("Git", list.get(0));
    }
}