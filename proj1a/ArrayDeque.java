public class ArrayDeque<T> {
    private T[] arrays;
    private int listSize;
    private int head;  //indicate where the list starts.
    private int end;   //indicate where the lists end

    /** Create an empty list. */
    public ArrayDeque() {
        arrays = (T[]) new Object[8];  //starting size of the array is 8
        listSize = 0;
        head = -1;   //represent no item in the array
        end = -1;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (isEmpty()) {
            arrays[0] = item;
            head = 0;
            end = 0;
            listSize = 1;
            return;
        }
        if (listSize == arrays.length) {
            resize(2);
        }
        if (head == 0) {  // in this situation, the head pointer should move to the end of the array
            head = arrays.length - 1;
        } else {
            head--;
        }
        arrays[head] = item;
        listSize++;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (isEmpty()) {
            arrays[0] = item;
            head = 0;
            end = 0;
            listSize = 1;
            return;
        }
        if (listSize == arrays.length) {
            resize(2);
        }
        if (end == arrays.length - 1) { // in this situation, the head pointer should move to zero.
            end = 0;
        } else {
            end++;
        }
        arrays[end] = item;
        listSize++;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return listSize == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return listSize;
    }

    /** Print the items in the deque.*/
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("There is no item in the list!");
            return;
        }
        int ptr = head;
        for (int i = 0; i < listSize; i++) {
            System.out.print(arrays[ptr] + " ");
            if (ptr == arrays.length - 1) {
                ptr = 0;
            } else {
                ptr++;
            }
        }
        System.out.println(" ");
    }

    /** Resize the array with a factor. */
    private void resize(double factor) {
        int newLength = (int) (arrays.length * factor);
        T[] newArrays = (T[]) new Object[newLength];
        if (isEmpty()) {
            arrays = newArrays;
            return;
        }

        if (head <= end) {
            System.arraycopy(arrays, head, newArrays, 0, listSize);
        } else {
            int firstPart = arrays.length - head;
            System.arraycopy(arrays, head, newArrays, 0, firstPart);
            System.arraycopy(arrays, 0, newArrays, firstPart, listSize - firstPart);
        }
        head = 0;
        end = listSize - 1;
        arrays = newArrays;
    }

    /**Remove and returns the item at the front of the deque. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (listSize == 1) {
            T item = arrays[head];
            head = -1;
            end = -1;
            listSize = 0;
            return item;
        }
        while ((((double) (listSize - 1)) / arrays.length < 0.25) && (arrays.length > 8)) {
            resize(0.5);
        }
        T item = arrays[head];
        if (head == arrays.length - 1) {
            head = 0;
        } else {
            head++;
        }
        listSize--;
        return item;
    }

    /** Remove and returns the item at the back of the deque. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (listSize == 1) {
            T item = arrays[end];
            head = -1;
            end = -1;
            listSize = 0;
            return item;
        }
        while ((((double) (listSize - 1)) / arrays.length < 0.25) && (arrays.length > 8)) {
            resize(0.5);
        }
        T item = arrays[end];
        if (end == 0) {
            end = arrays.length - 1;
        } else {
            end--;
        }
        listSize--;
        return item;
    }

    /** Get the item at the given index, if no such item exists, returns null. */
    public T get(int index) {
        if ((index > (listSize - 1)) || (index < 0)) {
            return null;
        }
        if (head <= end) {
            return arrays[head + index];
        } else {
            return arrays[(head + index) % arrays.length];
        }
    }

}
