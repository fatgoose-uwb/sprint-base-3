import Problem2.ArrayStack;
import Problem2.LinkedListStack;
import Problem2.MinStack;
import Problem2.Stack;
import org.junit.jupiter.api.Test;

import static Problem2.ValidParentheses.isValid;
import static org.junit.jupiter.api.Assertions.*;

// DO NOT REMOVE OR CHANGE ANYTHING

public class Problem2Test {
    @Test
    public void testStack() {
        Stack<Integer> arrayStack = new ArrayStack<>(10);
        Stack<Integer> linkedListStack = new LinkedListStack<>();

        // Polymorphism to shine here.
        // Both the Array Stack and linked list stack are tested with the same code.
        // Pretty neat, eh?
        testIntegerStack(arrayStack);
        testIntegerStack(linkedListStack);
    }

    /*
    this test function could be used to test all implementations of the Stack interface
     */
    private void testIntegerStack(Stack<Integer> stack) {
        assertEquals(0, stack.size());
        final int stackSize = 10;
        for (int i = 0; i < stackSize; i++) {
            // check push succeeds
            assertTrue(stack.push(i));

            // check the right value is at the top of the stack after pushed in
            assertEquals(i, stack.peek().intValue());
        }

        // check ArrayStack being full
        // a LinkedListStack can never be full
        boolean didPush = stack.push(99);
        if (stack instanceof ArrayStack) {
            assertFalse(didPush);
        } else {
            assertTrue(didPush);
            stack.pop();
        }

        // check pop
        for (int i = 0; i < stackSize; i++) {
            Integer val = assertDoesNotThrow(stack::pop);
            assertNotNull(val);
            assertEquals(stackSize - i - 1, val.intValue());
            assertEquals(stackSize - i - 1, stack.size());
        }
        assertEquals(0, stack.size());

        // pop when stack is empty
        Integer val = assertDoesNotThrow(stack::pop);
        assertNull(val);
    }

    @Test
    public void testValidParentheses() {
        String[] inputs = {
                "(}",
                "{}()",
                ")[](",
                "",
                "[]{}()",
                "[[{{}}]]()",
                "[()]{",
                "[]({})",
                "xx",
                "[[x]]",
                "[x",
                null
        };
        boolean[] expect = {false, true, false, true, true, true, false, true, false, false, false, true};

        for (int i = 0; i < inputs.length; i++) {
            boolean actual = isValid(inputs[i]);
            assertEquals(expect[i], actual, "case " + i);
        }
    }

    @Test
    public void testMinStackPushPop() {
        int[] inputs = {5, 4, 3, 2, 1};

        MinStack minStack = new MinStack(inputs.length);

        for (int input : inputs) {
            minStack.push(input);
        }

        for (int i = 0; i < inputs.length; i++) {
            Integer actual = minStack.getMin();
            Integer expect = inputs[inputs.length - i - 1];
            assertNotNull(actual);
            assertEquals(expect, actual);
            minStack.pop();
        }

        Integer actual = minStack.getMin();
        assertNull(actual);
    }

    @Test
    public void testMinStackPush() {
        int[][] inputs = {
                {},
                {1, 2},
                {2, 1},
                {2, 2},
                {1, 2, 3},
                {3, 2, 1},
                {3, 1, 2},
                {2, 1, 3},
                {2, 2, 2}};
        Integer[] outputs = {null, 1, 1, 2, 1, 1, 1, 1, 2};

        Integer[] expect = new Integer[outputs.length];
        for (int i = 0; i < outputs.length; i++) {
            boolean isInputEmpty = inputs[i].length == 0;
            expect[i] = isInputEmpty ? null : outputs[i];
        }

        for (int i = 0; i < inputs.length; i++) {
            int[] numbersToPush = inputs[i];

            MinStack minStack = new MinStack(numbersToPush.length);

            for (int toPush : numbersToPush) {
                minStack.push(toPush);
            }

            Integer actual = minStack.getMin();
            assertEquals(expect[i], actual);
        }
    }
}
