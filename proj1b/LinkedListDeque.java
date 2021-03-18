public class LinkedListDeque<T> implements Deque<T>{
    /** The size of the list. */
    private int listSize;
    /** The item in the list. */
    private class StuffNode {
        private StuffNode previous;  //points to the previous node
        private StuffNode next;    //points to the next node
        private T stuff;
    }
    private StuffNode sentinel;
    /** Create an empty list. */
    public LinkedListDeque() {
        sentinel = new StuffNode();
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
        listSize = 0;
    }

    /** Add an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item) {
        listSize++;
        StuffNode node = new StuffNode();
        node.stuff = item;
        node.next = sentinel.next;
        node.previous = sentinel;
        sentinel.next.previous = node;
        sentinel.next = node;
    }

    /** Add an item of type T to the back of the deque. */
    @Override
    public void addLast(T item) {
        listSize++;
        StuffNode node = new StuffNode();
        node.stuff = item;
        node.previous = sentinel.previous;
        node.next = sentinel;
        sentinel.previous.next = node;
        sentinel.previous = node;
    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    /**Returns the number of items in the deque. */
    @Override
    public int size() {
        return listSize;
    }

    /** Prints the number of items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("There is no item in the list!");
            return;
        }
        StuffNode ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.stuff + " ");
            ptr = ptr.next;
        }
        System.out.println(" ");
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.
     * */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.stuff;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        listSize--;
        return item;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.
     * */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.previous.stuff;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        listSize--;
        return item;
    }
    /** Get the item at the given index, where 0 is the front.
     *  If no such item exists, returns null.
     *  This method does NOT alter the deque.
     * */
    @Override
    public T get(int index) {
        if ((index + 1 > size()) || (index < 0)) {
            return null;
        }
        StuffNode ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.stuff;
    }

    /** The same as method get(), but uses recursion. */
    public T getRecursive(int index) {
        if ((index + 1 > size()) || (index < 0)) {
            return null;
        }

        return getRecursive(index, sentinel.next);
    }

    /** Helper method, return the item at the position from start. */
    private T getRecursive(int index, StuffNode start) {
        if (index == 0) {
            return start.stuff;
        } else {
            return getRecursive(index - 1, start.next);
        }
    }
}
