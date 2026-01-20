package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Binary Tree Level Order Traversal Tests")
class BinaryTreeLevelOrderTraversalTest {
    private BinaryTreeLevelOrderTraversal solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "BinaryTreeLevelOrderTraversal");
    }

    @Test
    @DisplayName("Example: Level order of [3,9,20,null,null,15,7]")
    void testLevelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        var result = solution.levelOrder(root);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(3), result.get(0));
        assertEquals(Arrays.asList(9, 20), result.get(1));
    }

    @Test
    @DisplayName("Empty tree returns empty list")
    void testEmpty() {
        assertTrue(solution.levelOrder(null).isEmpty());
    }
}
