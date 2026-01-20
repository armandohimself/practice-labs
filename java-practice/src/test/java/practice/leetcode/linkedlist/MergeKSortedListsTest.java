package practice.leetcode.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Merge K Sorted Lists Tests")
class MergeKSortedListsTest {

    private MergeKSortedLists solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.linkedlist", "MergeKSortedLists");
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
    @DisplayName("Example 1: Merge [[1,4,5],[1,3,4],[2,6]]")
    void testExample1() {
        ListNode[] lists = {
            createList(1, 4, 5),
            createList(1, 3, 4),
            createList(2, 6)
        };
        ListNode result = solution.mergeKLists(lists);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4, 5, 6}, toArray(result));
    }

    @Test
    @DisplayName("Example 2: Empty array")
    void testExample2() {
        ListNode[] lists = {};
        ListNode result = solution.mergeKLists(lists);
        assertNull(result);
    }

    @Test
    @DisplayName("Example 3: Array with one empty list")
    void testExample3() {
        ListNode[] lists = {null};
        ListNode result = solution.mergeKLists(lists);
        assertNull(result);
    }

    @Test
    @DisplayName("Single list should return same list")
    void testSingleList() {
        ListNode[] lists = {createList(1, 2, 3)};
        ListNode result = solution.mergeKLists(lists);
        assertArrayEquals(new int[]{1, 2, 3}, toArray(result));
    }
}
