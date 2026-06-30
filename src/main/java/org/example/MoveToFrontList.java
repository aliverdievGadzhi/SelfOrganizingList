package org.example;

/**
 * A self-organizing list that moves accessed elements to the front of the list.
 *
 * @param <T> the type of elements in the list
 */

public abstract class MoveToFrontList<T> extends AbstractSelfOrganizingList<T> implements SelfOrganizingList<T> {

        /**
         * Creates a new empty list.
         */
        public MoveToFrontList() {
        }

        /**
         * Creates a list with the given elements.
         *
         * @param elements the elements to be added to the list
         */
        public MoveToFrontList( T[] elements) {
            super(elements);
        }

        /**
         * Moves the accessed element to the front of the list.
         *
         * @param previous the previous element in the list to adjust the references
         * @param newHead  the new head of the list
         */
        protected void moveToFront( ListItem<T> previous, ListItem<T> newHead) {
            if (newHead == tail) {
                tail = previous;
            }
            previous.next = newHead.next;
            newHead.next = head;
            head = newHead;
        }
}
