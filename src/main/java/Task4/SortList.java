package Task4;

import Task1.ListNode;

public class SortList {
    // This could be used to make merging easier. Optional to use.
    private static final int SENTRY = Integer.MAX_VALUE;

    // Do not add any new member variable and member function

    // Do not change anything in sortList
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        // Break the list in half from the middle
        ListNode mid = findMidAndBreak(head);

        // Sort the first half of the list
        ListNode firstList = sortList(head);

        // Sort the second half of the list
        ListNode secondList = sortList(mid);

        // Merge the two sorted lists
        return mergeSortedSingleLinkedLists(firstList, secondList);
    }

    public static ListNode findMidAndBreak(ListNode head) {
        // TODO: homework
        return null; // TODO: placeholder. Replace with your own code
    }

    public static ListNode mergeSortedSingleLinkedLists(ListNode list1, ListNode list2) {
        // TODO: homework
        return null; // TODO: placeholder. Replace with your own code
    }
}
