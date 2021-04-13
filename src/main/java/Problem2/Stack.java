package Problem2;

// DO NOT REMOVE OR CHANGE ANYTHING
public interface Stack<T> {

    /*
    INSERT an element at the top of a stack
     */
    boolean push(T val);

    /*
    REMOVE and RETURN the element at the top of a stack
     */
    T pop();

    /*
    return the element the top of a stack
     */
    T peek();

    /*
    return the number of elements in the stack
     */
    int size();
}

