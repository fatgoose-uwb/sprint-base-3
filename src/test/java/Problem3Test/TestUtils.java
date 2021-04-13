package Problem3Test;

import Problem3.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// DO NOT REMOVE OR CHANGE ANYTHING

public class TestUtils {
    @Test
    public void testArrayToList() {
        Integer[][] inputs = {
                null,
                {},
                {1},
                {1, 2},
                {3, 3},
                {1, 4, 2},
                {3, 4, 5, 6, 7},
        };

        for (Integer[] input : inputs) {
            String caseId = String.format("case %s failed", Arrays.toString(input));
            ListNode<Integer> list = arrayToList(input);
            if (input == null) {
                assertNull(list, caseId);
                continue;
            }

            ListNode<Integer> ptr = list;
            for (int i = 0; i < input.length; i++) {
                ptr = ptr.next;
                assertEquals(input[i].intValue(), ptr.val.intValue(), caseId);
            }
            assertNull(ptr.next, caseId);
        }
    }

    private static <T> ListNode<T> arrayToList(T[] data) {
        if (data == null) {
            return null;
        }
        ListNode<T> head = new ListNode<>();  // dummy node
        ListNode<T> ptr = head;
        for (T value : data) {
            ptr.next = new ListNode<>(value);
            ptr = ptr.next;
        }
        return head;
    }
}
