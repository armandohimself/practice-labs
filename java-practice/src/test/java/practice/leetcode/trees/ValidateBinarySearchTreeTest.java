package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validate Binary Search Tree Tests")
class ValidateBinarySearchTreeTest {
    private ValidateBinarySearchTree solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "ValidateBinarySearchTree");
    }

    @Test
    @DisplayName("Example 1: [2,1,3] is valid BST")
    void testValid() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assertTrue(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Example 2: [5,1,4,null,null,3,6] is not valid BST")
    void testInvalid() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Single node is valid BST")
    void testSingleNode() {
        assertTrue(solution.isValidBST(new TreeNode(1)));
    }
}
