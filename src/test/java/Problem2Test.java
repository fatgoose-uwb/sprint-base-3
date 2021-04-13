import Problem2.SingleLinkedList;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Problem2Test {
    @Test
    public void testCopyConstructor() {
        // single node
        for (int i = 0; i < 5; i++) {
            SingleLinkedList theirList = new SingleLinkedList();
            for (int j = 0; j < i; j++) {
                theirList.add(i);
            }
            SingleLinkedList myList = new SingleLinkedList(theirList);
            assertEquals(theirList, myList);

            // change the list being copied to verify copy constructor
            // does deep copies, i.e. not just copy the head reference
            Random r = new Random();
            theirList.add(r.nextInt());
            assertNotEquals(theirList, myList);
        }
    }

    @Test
    public void testIterativeReverse() {
        int[][] inputs = {
                {},
                {1},
                {1, 2},
                {3, 3},
                {1, 4, 2},
                {3, 4, 5, 6, 7},
        };
        int[][] expected = {
                {},
                {1},
                {2, 1},
                {3, 3},
                {2, 4, 1},
                {7, 6, 5, 4, 3},
        };
        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = new SingleLinkedList(inputs[i]);
            SingleLinkedList reversed = new SingleLinkedList(expected[i]);
            list.reverse();
            assertEquals(reversed, list);
        }
    }

    @Test
    public void testRemoveAll() {
        int[][] inputs = {
                {1, 2, 3},
                {1, 2, 4, 2},
                {1, 1, 4, 2},
                {3, 3, 3, 3},
                {1, 1, 4, 2},
        };
        int[] targets = {3, 2, 1, 3, 5};
        int[][] expects = {
                {1, 2},
                {1, 4},
                {4, 2},
                {},
                {1, 1, 4, 2},
        };
        int[] expectedSize = {2, 2, 2, 0, 4};
        int[] expectedCounts = {1, 2, 2, 4, 0};

        // empty list
        SingleLinkedList emptyList = new SingleLinkedList();
        int count = emptyList.removeAll(3);
        assertEquals(emptyList.getSize(), 0);
        assertEquals(0, count);

        // non-empty list
        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = new SingleLinkedList(inputs[i]);
            SingleLinkedList expectedList = new SingleLinkedList(expects[i]);
            int actualRemoved = list.removeAll(targets[i]);

            assertEquals(expectedList, list);
            assertEquals(expectedCounts[i], actualRemoved);
            assertEquals(expectedSize[i], list.getSize());
        }
    }

    @Test
    public void testEquals() {
        int[][] list1 = {
                null,
                null,
                {},
                {1},
                {1},
                {1, 2},
                {2, 2},
                {1, 2, 3},
                {1, 2, 3},
                {-1, 2, 3},
        };
        int[][] list2 = {
                null,
                {},
                {},
                {},
                {1},
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3},
        };
        boolean[] expect = {
                true, true, true, false, true, true, false, false, true, false,
        };

        assertEquals(list1.length, list2.length);
        assertEquals(list1.length, expect.length);

        for (int i = 0; i < list1.length; i++) {
            SingleLinkedList l1 = new SingleLinkedList(list1[i]);
            SingleLinkedList l2 = new SingleLinkedList(list2[i]);
            assertBothWays(l1, l2, expect[i], i);
        }
    }

    private void assertBothWays(SingleLinkedList l1, SingleLinkedList l2, boolean check, int caseId) {
        String caseIdStr = String.format("case %d", caseId);
        if (check) {
            assertEquals(caseIdStr, l1, l2);
            assertEquals(caseIdStr, l2, l1);
        } else {
            assertNotEquals(caseIdStr, l1, l2);
            assertNotEquals(caseIdStr, l2, l1);
        }
    }
}