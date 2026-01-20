package practice.leetcode.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Remove Nth Node From End Tests")
class RemoveNthNodeFromEndTest {

    private RemoveNthNodeFromEnd solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.linkedlist", "RemoveNthNodeFromEnd");
    }

    private ListNode createList(int... values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private int[] toArray(ListNode head) {
        if (head == null) return new int[0];
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int[] result = new int[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            result[i] = temp.val;
            temp = temp.next;
        }
        return result;
    }

    @Test
    @DisplayName("Example 1: Remove 2nd node from end of [1,2,3,4,5]")
    void testExample1() {
        ListNode head = createList(1, 2, 3, 4, 5);
        ListNode result = solution.removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{1, 2, 3, 5}, toArray(result));
    }

    @Test
    @DisplayName("Example 2: Remove only node from [1]")
    void testExample2() {
        ListNode head = createList(1);
        ListNode result = solution.removeNthFromEnd(head, 1);
        assertNull(result);
    }

    @Test
    @DisplayName("Example 3: Remove last node from [1,2]")
    void testExample3() {
        ListNode head = createList(1, 2);
        ListNode result = solution.removeNthFromEnd(head, 1);
        assertArrayEquals(new int[]{1}, toArray(result));
    }

    @Test
    @DisplayName("Remove first node (from end)")
    void testRemoveFirst() {
        ListNode head = createList(1, 2, 3);
        ListNode result = solution.removeNthFromEnd(head, 3);
        assertArrayEquals(new int[]{2, 3}, toArray(result));
    }
}
