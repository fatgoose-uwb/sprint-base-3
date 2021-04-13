package Problem3;

// DO NOT REMOVE OR CHANGE ANYTHING

/*
generic class. see https://www.geeksforgeeks.org/generics-in-java/
 */
public class ListNode<T> {
    public T val;   // better to be private. public here for demo purpose
    public ListNode<T> next; // better to be private. public here for demo purpose

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }
}
