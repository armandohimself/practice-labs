package practice.leetcode.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Serialize and Deserialize Binary Tree Tests")
class SerializeAndDeserializeBinaryTreeTest {
    private SerializeAndDeserializeBinaryTree solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.trees", "SerializeAndDeserializeBinaryTree");
    }

    @Test
    @DisplayName("Serialize and deserialize [1,2,3,null,null,4,5]")
    void testSerializeDeserialize() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));

        String serialized = solution.serialize(root);
        TreeNode deserialized = solution.deserialize(serialized);

        assertEquals(root.val, deserialized.val);
        assertEquals(root.left.val, deserialized.left.val);
    }

    @Test
    @DisplayName("Empty tree")
    void testEmpty() {
        String serialized = solution.serialize(null);
        TreeNode deserialized = solution.deserialize(serialized);
        assertNull(deserialized);
    }
}
