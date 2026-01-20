package practice.leetcode.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Reverse Linked List Tests")
class ReverseLinkedListTest {

    private ReverseLinkedList solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.linkedlist", "ReverseLinkedList");
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
    @DisplayName("Example 1: [1,2,3,4,5] should return [5,4,3,2,1]")
    void testExample1() {
        ListNode head = createList(1, 2, 3, 4, 5);
        ListNode result = solution.reverseList(head);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(result));
    }

    @Test
    @DisplayName("Example 2: [1,2] should return [2,1]")
    void testExample2() {
        ListNode head = createList(1, 2);
        ListNode result = solution.reverseList(head);
        assertArrayEquals(new int[]{2, 1}, toArray(result));
    }

    @Test
    @DisplayName("Example 3: [] should return []")
    void testExample3() {
        ListNode result = solution.reverseList(null);
        assertNull(result);
    }

    @Test
    @DisplayName("Single node should return same node")
    void testSingleNode() {
        ListNode head = createList(1);
        ListNode result = solution.reverseList(head);
        assertArrayEquals(new int[]{1}, toArray(result));
    }
}
