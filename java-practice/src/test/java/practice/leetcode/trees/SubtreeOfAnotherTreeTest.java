package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Subtree of Another Tree Tests")
class SubtreeOfAnotherTreeTest {
    private SubtreeOfAnotherTree solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "SubtreeOfAnotherTree");
    }

    @Test
    @DisplayName("Example 1: [4,1,2] is subtree of [3,4,5,1,2]")
    void testIsSubtree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        root.right = new TreeNode(5);
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        assertTrue(solution.isSubtree(root, subRoot));
    }

    @Test
    @DisplayName("Example 2: Not a subtree with extra node")
    void testNotSubtree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        root.left.left.left = new TreeNode(0);
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        assertFalse(solution.isSubtree(root, subRoot));
    }
}
