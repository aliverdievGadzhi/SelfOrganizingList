package org.example;

import java.util.NoSuchElementException;
/**
 * A self-organizing list is a data structure that organizes its elements based on access patterns to improve
 * access times for frequently accessed elements.
 *
 * @param <T> the type of elements in the list
 */

public interface SelfOrganizingList<T> {

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    int size();

    /**
     * Adds a new element to the end of the list.
     *
     * @param element the element to add
     */
    void add(T element);


    /**
     * Removes the given key from the list.
     *
     * @param key the key to remove
     *
     * @throws NoSuchElementException if the key is not found in the list
     */
    void remove(T key) throws NoSuchElementException;

    /**
     * Returns the key at the given index.
     *
     * @param index the index of the key to return
     *
     * @return the key at the given index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * Allows the self-organizing list to be used in a standard for-each loop.
     *
     * @return an Iterator to traverse the list items from head to tail
     */
    java.util.Iterator<T> iterator();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T remove(int index) throws IndexOutOfBoundsException;

    /**
     * Checks if the list contains the specified element.
     * The specific self-organization strategy is applied upon a successful search.
     *
     * @param element the element to search for
     */
     boolean contains(T element);

    /**
     * Reverses the list in place by changing the directions of all node pointers.
     */
     void reverse();
}


