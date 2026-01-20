package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Invert Binary Tree Tests")
class InvertBinaryTreeTest {
    private InvertBinaryTree solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "InvertBinaryTree");
    }

    @Test
    @DisplayName("Example: Invert tree [4,2,7,1,3,6,9]")
    void testInvert() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode result = solution.invertTree(root);
        assertEquals(7, result.left.val);
        assertEquals(2, result.right.val);
    }

    @Test
    @DisplayName("Empty tree returns null")
    void testEmpty() {
        assertNull(solution.invertTree(null));
    }
}
