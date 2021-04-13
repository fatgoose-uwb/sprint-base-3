package Problem2;

public class MinStack extends ArrayStack<Integer> {

    // do not add or change member variables
    // data is stored in the "T[] data" array in the base class
    private Stack<Integer> dataStore;

    public MinStack(int size) {
        // TODO: your code here
        super(size); // place holder
    }

    @Override
    public boolean push(Integer val) {
        // TODO: your code here
        return false; // TODO: replace this with your code
    }

    @Override
    public Integer pop() {
        // TODO: your code here
        return -1; // TODO: replace this with your code
    }

    public Integer getMin() {
        // TODO: your code here
        // loop of any kind is not allowed
        return -1; // TODO: replace this with your code
    }
}

