package org.example;

import java.util.NoSuchElementException;


public abstract class AbstractSelfOrganizingList<T> implements SelfOrganizingList<T> {

    /**
     * The reference to the head (first element) of the list.
     */

    protected  ListItem<T> head;

    /**
     * The reference to the tail (last element) of the list.
     */

    protected ListItem<T> tail;

    /**
     * The number of elements in the list.
     */

    protected int size;

    /**
     * Creates an empty list.
     */

    public AbstractSelfOrganizingList() {
    }

    /**
     * Creates a list with the given elements.
     *
     * @param elements the elements to be added to the list
     */
    public AbstractSelfOrganizingList( T[] elements) {
        if (elements.length == 0) {
            return;
        }
        head = new ListItem<>(elements[0]);
        tail = head;
        for (int i = 1; i < elements.length; i++) {
            tail.next = new ListItem<>(elements[i]);
            tail = tail.next;
        }
        size = elements.length;
    }


    @Override
    public int size() {
        return size;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param element the element to add
     */
    public void add(T element) {
        ListItem<T> newItem = new ListItem<>(element);
        if (head == null) {
            head = newItem;
            tail = newItem;
        } else {
            tail.next = newItem;
            tail = newItem;
        }
        size++;
    }

    @Override
    public void remove(T key) throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.key.equals(key)) {
            head = head.next;
            size--;
            return;
        }
        for (ListItem<T> cursor = head; cursor.next != null; cursor = cursor.next) {
            if (cursor.next.key.equals(key)) {
                if (cursor.next == tail) {
                    tail = cursor;
                }
                cursor.next = cursor.next.next;
                size--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        if (head == null) {
            return "null";
        }
        return head.toString();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private ListItem<T> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("No more elements in the list");
                }
                T value = cursor.key;
                cursor = cursor.next;
                return value;
            }
        };
    }
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedKey;

        if (index == 0) {
            removedKey = head.key;
            if (head == tail) {
                tail = null;
            }
            head = head.next;
        } else {

            ListItem<T> cursor = head;

            for (int i = 1; i < index; i++) {
                cursor = cursor.next;
            }

            ListItem<T> target = cursor.next;
            removedKey = target.key;

            if (target == tail) {
                tail = cursor;
            }
            cursor.next = target.next;
        }
        size--;
        return removedKey;
    }

    public void reverse() {
        if (head == null || head.next == null) return;

        ListItem<T> prev = null;
        ListItem<T> current = head;
        ListItem<T> next = null;

        tail = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev; 
    }

}
