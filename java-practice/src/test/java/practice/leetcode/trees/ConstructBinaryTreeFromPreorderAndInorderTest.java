package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Construct Binary Tree from Preorder and Inorder Tests")
class ConstructBinaryTreeFromPreorderAndInorderTest {
    private ConstructBinaryTreeFromPreorderAndInorder solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "ConstructBinaryTreeFromPreorderAndInorder");
    }

    @Test
    @DisplayName("Example: Build tree from preorder=[3,9,20,15,7], inorder=[9,3,15,20,7]")
    void testBuildTree() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = solution.buildTree(preorder, inorder);
        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertEquals(20, result.right.val);
    }

    @Test
    @DisplayName("Single node tree")
    void testSingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode result = solution.buildTree(preorder, inorder);
        assertEquals(1, result.val);
    }
}
