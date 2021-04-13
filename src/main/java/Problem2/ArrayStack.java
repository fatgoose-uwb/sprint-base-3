package Problem2;

/*
a stack that stores data in an array
 */
public class ArrayStack<T> implements Stack<T> {
    // do not add or change member variables
    private T[] data;
    private int size;   // number of elements in the stack

    public ArrayStack(int capacity) {
        // no, we do not need to store the capacity variable
        // as a member variable because it can be inferred from the data array
        // TODO: your code here
    }

    @Override
    public boolean push(T val) {
        // add to the end of the array
        // TODO: your code here
        return false; // TODO: replace this with your code
    }

    @Override
    public T pop() {
        // TODO: your code here
        T val = null;   // TODO: replace this with your code
        return val;   // TODO: replace this with your code
    }

    @Override
    public T peek() {
        // TODO: your code here
        T val = null;   // TODO: replace this with your code
        return val;   // TODO: replace this with your code
    }

    @Override
    public int size() {
        return size;
    }
}
