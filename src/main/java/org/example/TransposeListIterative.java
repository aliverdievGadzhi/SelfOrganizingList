package org.example;

/**
 * An iterative implementation of a self-organizing list that transposes accessed elements with their previous element.
 *
 * @param <T> the type of elements in the list
 */
public class TransposeListIterative<T> extends TransposeList<T>{
    /**
     * Creates a new empty list.
     */

    public TransposeListIterative() {
    }

    /**
     * Creates a list with the given elements.
     *
     * @param elements the elements to be added to the list
     */
    public TransposeListIterative( T[] elements) {
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

        if (head.next != null && head.next.key.equals(element)) {
            ListItem<T> target = head.next;

            if (target == tail) {
                tail = head;
            }

            head.next = target.next;
            target.next = head;
            head = target;
            return true;
        }

        ListItem<T> prevPrev = head;
        while (prevPrev.next != null && prevPrev.next.next != null
                && !prevPrev.next.next.key.equals(element)) {
            prevPrev = prevPrev.next;
        }

        if (prevPrev.next != null && prevPrev.next.next != null) {
            ListItem<T> prev = prevPrev.next;
            ListItem<T> target = prev.next;

            if (target == tail) {
                tail = prev;
            }


            prev.next = target.next;
            target.next = prev;
            prevPrev.next = target;

            return true;
        }

        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            return head.key;
        }
        ListItem<T> cursor = head;
        ListItem<T> previous = null;
        for (int i = 1; i < index; i++) {
            previous = cursor;
            cursor = cursor.next;
        }
        T res =  cursor.next.key;
        transpose(cursor, previous);
        return res;
    }
}
