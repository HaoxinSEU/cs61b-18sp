public interface Deque<T> {
    void addFirst(T item);  //add an item at the front
    void addLast(T item);   //add an item at the last
    boolean isEmpty();   // return true when the deque is empty
    int size();   // return the size of the deque
    void printDeque();  //prints all the items in the deque
    T removeFirst();  // removes and returns the first item in the deque
    T removeLast();  //removes and returns the last item in the deque
    T get(int index);  // get the ith item in the deque
}
