package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lowest Common Ancestor of BST Tests")
class LowestCommonAncestorOfBSTTest {
    private LowestCommonAncestorOfBST solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "LowestCommonAncestorOfBST");
    }

    @Test
    @DisplayName("Example: LCA of 2 and 8 in BST")
    void testLCA() {
        TreeNode root = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        root.left = p;
        root.right = q;
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        assertEquals(6, result.val);
    }

    @Test
    @DisplayName("One node is ancestor of other")
    void testOneIsAncestor() {
        TreeNode root = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        root.left = p;
        root.left.right = new TreeNode(4);
        TreeNode result = solution.lowestCommonAncestor(root, p, root.left.right);
        assertEquals(2, result.val);
    }
}
