package Problem3;

/*
why Improv? https://youtu.be/VhkcmN-CCYw
 */

import java.io.PrintStream;

public class StoryBuilder {

    private ListNode<String> sequenceStart;

    public static String CONNECTOR = "yes, and ";   // used here and in test

    public void buildWithYesAnd(String sentence) {
        // TODO: your code here
        // must insert sentence at the FRONT (head) of the linked list (different from quiz-3)
        // O(1) complexity, meaning no loop of any kind is allowed in this function
    }

    /*
    this is an example of dependency injection through polymorphism using Java interface
    check testStoryTelling for clues of how this is supposed to work
     */
    public void tellStory(PrintStream print) {
        // must use LinkedListStack from problem 1
        // TODO: your code here
    }

    /*
    check testStoryBuilding for clues of how this is supposed to work
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        // TODO: your code here
        // must use LinkedListStack from problem 1
        // any other collection data structure is not allowed. check with instructor if not sure

        return buffer.toString();   // DO NOT REMOVE OR CHANGE THIS
    }
}
