package Problem1;

import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
    // use Java LinkedList to store the data
    // do not change member variables
    private LinkedList<T> data;

    public LinkedListStack() {
        // homework
    }

    @Override
    public boolean push(T val) {
        // homework
        return false;   // place holder
    }

    @Override
    public T pop() {
        // homework
        T val = null;   // place holder
        return val;   // place holder
    }

    @Override
    public T peek() {
        // homework
        T val = null;   // place holder
        return val;   // place holder
    }

    @Override
    public int size() {
        return data.size();
    }
}
