package Problem2;

import java.util.LinkedList;

/*
    a stack that stores data in a single linked list
 */
public class LinkedListStack<T> implements Stack<T> {
    // use Java LinkedList to store the data
    // do not change member variables
    private LinkedList<T> data;

    public LinkedListStack() {
        // TODO: your code here
    }

    @Override
    public boolean push(T val) {
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
        return data.size();
    }
}
