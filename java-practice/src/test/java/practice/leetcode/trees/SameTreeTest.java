package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Same Tree Tests")
class SameTreeTest {

    private SameTree solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "SameTree");
    }

    @Test
    @DisplayName("Example 1: [1,2,3] and [1,2,3] are the same")
    void testExample1() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertTrue(solution.isSameTree(p, q));
    }

    @Test
    @DisplayName("Example 2: [1,2] and [1,null,2] are different")
    void testExample2() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        assertFalse(solution.isSameTree(p, q));
    }

    @Test
    @DisplayName("Example 3: [1,2,1] and [1,1,2] are different")
    void testExample3() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        assertFalse(solution.isSameTree(p, q));
    }

    @Test
    @DisplayName("Both null trees are the same")
    void testBothNull() {
        assertTrue(solution.isSameTree(null, null));
    }
}
