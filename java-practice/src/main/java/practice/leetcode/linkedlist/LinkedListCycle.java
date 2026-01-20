package practice.leetcode.linkedlist;

/**
 * Linked List Cycle (LeetCode #141)
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example 1:
 *   Input: head = [3,2,0,-4], pos = 1 (cycle at node with value 2)
 *   Output: true
 *
 * Example 2:
 *   Input: head = [1,2], pos = 0 (cycle at node with value 1)
 *   Output: true
 *
 * Example 3:
 *   Input: head = [1], pos = -1 (no cycle)
 *   Output: false
 */
public class LinkedListCycle {

    /**
     * Detects if linked list has a cycle.
     *
     * @param head the head of the linked list
     * @return true if there is a cycle
     */
    public boolean hasCycle(ListNode head) {
        // TODO: Implement your solution here (consider Floyd's cycle detection)
        return false;
    }
}
