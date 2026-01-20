package practice.leetcode.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Linked List Cycle Tests")
class LinkedListCycleTest {

    private LinkedListCycle solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.linkedlist", "LinkedListCycle");
    }

    @Test
    @DisplayName("Example 1: List with cycle should return true")
    void testExample1() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle
        assertTrue(solution.hasCycle(node1));
    }

    @Test
    @DisplayName("Example 2: List with cycle at head should return true")
    void testExample2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1; // cycle
        assertTrue(solution.hasCycle(node1));
    }

    @Test
    @DisplayName("Example 3: List without cycle should return false")
    void testExample3() {
        ListNode node1 = new ListNode(1);
        assertFalse(solution.hasCycle(node1));
    }

    @Test
    @DisplayName("Empty list should return false")
    void testEmptyList() {
        assertFalse(solution.hasCycle(null));
    }

    @Test
    @DisplayName("Two nodes without cycle should return false")
    void testTwoNodesNoCycle() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        assertFalse(solution.hasCycle(node1));
    }
}
