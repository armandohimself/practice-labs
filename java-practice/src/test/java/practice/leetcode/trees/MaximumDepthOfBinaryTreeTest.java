package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Maximum Depth of Binary Tree Tests")
class MaximumDepthOfBinaryTreeTest {

    private MaximumDepthOfBinaryTree solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "MaximumDepthOfBinaryTree");
    }

    @Test
    @DisplayName("Example 1: Tree [3,9,20,null,null,15,7] has depth 3")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Example 2: Tree [1,null,2] has depth 2")
    void testExample2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        assertEquals(2, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Empty tree has depth 0")
    void testEmpty() {
        assertEquals(0, solution.maxDepth(null));
    }

    @Test
    @DisplayName("Single node has depth 1")
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.maxDepth(root));
    }
}
