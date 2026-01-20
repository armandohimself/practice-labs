package practice.leetcode.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Reorder List Tests")
class ReorderListTest {

    private ReorderList solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.linkedlist", "ReorderList");
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
    @DisplayName("Example 1: [1,2,3,4] should become [1,4,2,3]")
    void testExample1() {
        ListNode head = createList(1, 2, 3, 4);
        solution.reorderList(head);
        assertArrayEquals(new int[]{1, 4, 2, 3}, toArray(head));
    }

    @Test
    @DisplayName("Example 2: [1,2,3,4,5] should become [1,5,2,4,3]")
    void testExample2() {
        ListNode head = createList(1, 2, 3, 4, 5);
        solution.reorderList(head);
        assertArrayEquals(new int[]{1, 5, 2, 4, 3}, toArray(head));
    }

    @Test
    @DisplayName("Single node should remain unchanged")
    void testSingleNode() {
        ListNode head = createList(1);
        solution.reorderList(head);
        assertArrayEquals(new int[]{1}, toArray(head));
    }

    @Test
    @DisplayName("Two nodes should swap")
    void testTwoNodes() {
        ListNode head = createList(1, 2);
        solution.reorderList(head);
        assertArrayEquals(new int[]{1, 2}, toArray(head));
    }
}
