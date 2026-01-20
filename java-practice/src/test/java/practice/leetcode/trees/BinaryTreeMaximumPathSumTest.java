package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Binary Tree Maximum Path Sum Tests")
class BinaryTreeMaximumPathSumTest {
    private BinaryTreeMaximumPathSum solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "BinaryTreeMaximumPathSum");
    }

    @Test
    @DisplayName("Example 1: [1,2,3] max path sum is 6")
    void testExample1() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(6, solution.maxPathSum(root));
    }

    @Test
    @DisplayName("Example 2: [-10,9,20,null,null,15,7] max path sum is 42")
    void testExample2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        assertEquals(42, solution.maxPathSum(root));
    }

    @Test
    @DisplayName("Single node")
    void testSingleNode() {
        assertEquals(5, solution.maxPathSum(new TreeNode(5)));
    }
}
