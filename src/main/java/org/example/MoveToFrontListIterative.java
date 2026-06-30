package org.example;

/**
 * An iterative implementation of a self-organizing list that moves accessed elements to the front of the list.
 *
 * @param <T> the type of elements in the list
 *
 */

public class MoveToFrontListIterative<T> extends MoveToFrontList<T>{
    /**
     * Creates a new empty list.
     */
    public MoveToFrontListIterative() {
        super();
    }

    /**
     * Creates a list with the given elements.
     *
     * @param elements the elements to be added to the list
     */
    public MoveToFrontListIterative(T[] elements) {
        super(elements);
    }

    @Override
    public boolean contains(T element) {
        if (head == null) {
            return false;
        }
        if (head.key.equals(element)) {
            return true;
        }
        ListItem<T> cursor = head;
        while (cursor.next != null && !cursor.next.key.equals(element)) {
            cursor = cursor.next;
        }
        if (cursor.next != null) {
            ListItem<T> target = cursor.next;

            if (target == tail) {
                tail = cursor;
            }
            cursor.next = target.next;
            target.next = head;
            head = target;

            return true;
        }

        return false;
    }

    /**
     * A Method for Retrieving an Element by Index with Search Optimization
     * Using the Move-To-Front Strategy
     *
     * @return the key of the retrieved list item shifted to the head
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            return head.key;
        }
        ListItem<T> cursor = head;
        for (int i = 1; i < index; i++) {
            cursor = cursor.next;
        }
        ListItem<T> newHead = cursor.next;
        moveToFront(cursor, newHead);
        return newHead.key;
    }
}
