package practice.leetcode.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Merge Two Sorted Lists Tests")
class MergeTwoSortedListsTest {

    private MergeTwoSortedLists solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.linkedlist", "MergeTwoSortedLists");
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
    @DisplayName("Example 1: Merge [1,2,4] and [1,3,4]")
    void testExample1() {
        ListNode list1 = createList(1, 2, 4);
        ListNode list2 = createList(1, 3, 4);
        ListNode result = solution.mergeTwoLists(list1, list2);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, toArray(result));
    }

    @Test
    @DisplayName("Example 2: Both lists empty")
    void testExample2() {
        ListNode result = solution.mergeTwoLists(null, null);
        assertNull(result);
    }

    @Test
    @DisplayName("Example 3: First list empty")
    void testExample3() {
        ListNode list2 = createList(0);
        ListNode result = solution.mergeTwoLists(null, list2);
        assertArrayEquals(new int[]{0}, toArray(result));
    }

    @Test
    @DisplayName("Second list empty")
    void testSecondEmpty() {
        ListNode list1 = createList(1, 2, 3);
        ListNode result = solution.mergeTwoLists(list1, null);
        assertArrayEquals(new int[]{1, 2, 3}, toArray(result));
    }
}
