package org.example;

/**
 * A self-organizing list that transposes accessed elements with the previous element in the list moving it one
 * position to the front.
 *
 * @param <T> the type of elements in the list
 */
public abstract class TransposeList<T> extends AbstractSelfOrganizingList<T> implements SelfOrganizingList<T> {

    /**
     * Creates a new empty list.
     */
    public TransposeList() {
    }

    /**
     * Creates a list with the given elements.
     *
     * @param elements the elements to be added to the list
     */

    public TransposeList( T[] elements) {
        super(elements);
    }

    /**
     * Transposes the accessed element with the previous element in the list moving it one position to the front.
     *
     * @param previous       the previous element in the list to adjust the references
     * @param previousBefore the element before the previous element in the list to switch places with previous
     */
    protected void transpose(ListItem<T> previous, ListItem<T> previousBefore) {
        if (previous.next == tail) {
            tail = previous;
        }
        if (previousBefore == null) {
            // Case: Swap head and head.next
            head = previous.next;
            previous.next = head.next;
            head.next = previous;
        } else {
            // Case: Move the node one position to the front
            previousBefore.next = previous.next;
            previous.next = previous.next.next;
            previousBefore.next.next = previous;
        }
    }
}