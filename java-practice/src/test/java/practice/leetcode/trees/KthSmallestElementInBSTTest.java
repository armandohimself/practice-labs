package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Kth Smallest Element in BST Tests")
class KthSmallestElementInBSTTest {
    private KthSmallestElementInBST solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "KthSmallestElementInBST");
    }

    @Test
    @DisplayName("Example 1: k=1 in [3,1,4,null,2]")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1, null, new TreeNode(2));
        root.right = new TreeNode(4);
        assertEquals(1, solution.kthSmallest(root, 1));
    }

    @Test
    @DisplayName("Example 2: k=3 in [5,3,6,2,4,null,null,1]")
    void testExample2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        root.right = new TreeNode(6);
        assertEquals(3, solution.kthSmallest(root, 3));
    }
}
