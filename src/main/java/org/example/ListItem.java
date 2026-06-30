package org.example;

import java.util.Objects;

public final class ListItem<T> {

    /**
     * The key of the list item.
     */
    final T key;

    /**
     * The reference to the next element in the list.
     */
    ListItem<T> next;

    /**
     * Creates a list item with the given key.
     *
     * @param key the key of the list item
     */
    public ListItem(T key) {
        this.key = key;
    }

    /**
     * Creates a list item sequence with the given keys.
     *
     * @param keys the keys of the list items
     */
    public ListItem( T[] keys) {
        if (keys.length == 0) {
            throw new IllegalArgumentException("The item must be non-empty");
        }
        this.key = keys[0];
        ListItem<T> cursor = this;
        for (int i = 1; i < keys.length; i++) {
            cursor.next = new ListItem<>(keys[i]);
            cursor = cursor.next;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof ListItem<?> listItem
                && Objects.equals(key, listItem.key)
                && Objects.equals(next, listItem.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, next);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListItem<T> cursor = this;

        while (cursor != null) {
            builder.append("[").append(cursor.key).append("] -> ");
            cursor = cursor.next;
        }
        builder.append("null");
        return builder.toString();
    }
}


