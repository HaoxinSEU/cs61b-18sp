public interface Deque <T> {
    public void addFirst(T item);  //add an item at the front
    public void addLast(T item);   //add an item at the last
    public boolean isEmpty();   // return true when the deque is empty
    public int size();   // return the size of the deque
    public void printDeque();  //prints all the items in the deque
    public T removeFirst();  // removes and returns the first item in the deque
    public T removeLast();  //removes and returns the last item in the deque
    public T get(int index);  // get the ith item in the deque
}
