/*
 * DO NOT MAKE ANY CHANGES
 */

import Task5.TaskManager;
import Task5.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * DO NOT MAKE ANY CHANGES
 */

class TaskGenerator {

    public static TreeNode<String> generateTasks(int n) {
        if (n < 0) return null;

        // Prepare task array
        String[] tasks = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            tasks[i] = "task" + i;
        }

        return buildBalanced(tasks, 0, n);
    }

    private static TreeNode<String> buildBalanced(String[] tasks, int low, int high) {
        if (low > high) return null;

        // Pick the middle element as the root to keep the tree balanced
        int mid = (low + high) / 2;

        TreeNode<String> node = new TreeNode<>(tasks[mid]);
        node.left = buildBalanced(tasks, low, mid - 1);
        node.right = buildBalanced(tasks, mid + 1, high);

        return node;
    }
}

public class Task5Test {
    @Test
    public void testSort4Tasks() {

        //     task1
        //    /     \
        // task0    task2
        //               \
        //               task3
        TreeNode<String> inputTaskTree = TaskGenerator.generateTasks(3);

        // Expected ordered tasks:
        List<String> expectedOrderedTasks = Arrays.asList("task3", "task2", "task0", "task1");
        List<String> actualOrderedTasks = TaskManager.sort(inputTaskTree);
        assertEquals("Tasks are not in correct reverse post-order traversal", expectedOrderedTasks, actualOrderedTasks);
    }

    @Test
    public void testSort3Tasks() {
        //       task1
        //     /       \
        //  task0      task2
        TreeNode<String> inputTaskTree = TaskGenerator.generateTasks(2);

        // Expected ordered tasks:
        List<String> expectedOrderedTasks = Arrays.asList("task2", "task0", "task1");
        List<String> actualOrderedTasks = TaskManager.sort(inputTaskTree);
        assertEquals("Tasks are not in correct reverse post-order traversal", expectedOrderedTasks, actualOrderedTasks);
    }

    @Test
    public void testSort6Tasks() {
        //       task2
        //     /       \
        //  task0      task4
        //     \       /   \
        //     task1  task3 task5
        TreeNode<String> inputTaskTree = TaskGenerator.generateTasks(5);

        // Expected ordered tasks:
        List<String> expectedOrderedTasks = Arrays.asList("task5", "task3", "task4", "task1", "task0", "task2");
        List<String> actualOrderedTasks = TaskManager.sort(inputTaskTree);
        assertEquals("Tasks are not in correct reverse post-order traversal", expectedOrderedTasks, actualOrderedTasks);
    }

    @Test
    public void testMorningTasks() {
        //                  drive to school
        //                  /             \
        //          start_car            feed_cat
        //           /     \
        // find_car_key  have_breakfast
        //                 /       \
        //           cool_egg  make_coffee
        TreeNode<String> inputTaskTree = new TreeNode<String>("Drive to school");
        inputTaskTree.left = new TreeNode<String>("Start car");
        inputTaskTree.left.left = new TreeNode<String>("Find car key");
        inputTaskTree.left.right = new TreeNode<String>("Have breakfast");
        inputTaskTree.left.right.left = new TreeNode<String>("Cool egg");
        inputTaskTree.left.right.right = new TreeNode<String>("Make coffee");
        inputTaskTree.right = new TreeNode<String>("Feed cat");

        // Expected ordered tasks:
        List<String> expectedOrderedTasks = Arrays.asList("Feed cat", "Make coffee", "Cool egg", "Have breakfast", "Find car key", "Start car", "Drive to school");
        List<String> actualOrderedTasks = TaskManager.sort(inputTaskTree);
        assertEquals("Tasks are not in correct reverse post-order traversal", expectedOrderedTasks, actualOrderedTasks);
    }

    @Test
    public void testGenerateTasksBalancedTrees() {
        // n = 1
        // Expected Tree:
        //   task0
        //        \
        //        task1
        TreeNode<String> expected1 = new TreeNode<>("task0");
        expected1.right = new TreeNode<>("task1");
        TreeNode<String> actual1 = TaskGenerator.generateTasks(1);
        assertTrue("Tree for n=1 does not match expected structure", treeEquals(expected1, actual1));
        assertTrue("Tree for n=1 should be balanced", isBalanced(actual1));

        // n = 2
        // Expected Tree:
        //     task1
        //    /     \
        // task0    task2
        TreeNode<String> expected2 = new TreeNode<>("task1");
        expected2.left = new TreeNode<>("task0");
        expected2.right = new TreeNode<>("task2");
        TreeNode<String> actual2 = TaskGenerator.generateTasks(2);
        assertTrue("Tree for n=2 does not match expected structure", treeEquals(expected2, actual2));
        assertTrue("Tree for n=2 should be balanced", isBalanced(actual2));

        // n = 3
        // Expected Tree:
        //     task1
        //    /     \
        // task0    task2
        //               \
        //               task3
        TreeNode<String> expected3 = new TreeNode<>("task1");
        expected3.left = new TreeNode<>("task0");
        expected3.right = new TreeNode<>("task2");
        expected3.right.right = new TreeNode<>("task3");
        TreeNode<String> actual3 = TaskGenerator.generateTasks(3);
        assertTrue("Tree for n=3 does not match expected structure", treeEquals(expected3, actual3));
        assertTrue("Tree for n=3 should be balanced", isBalanced(actual3));

        // n = 4
        // Expected Tree:
        //      task2
        //     /     \
        //  task0    task3
        //     \        \
        //     task1    task4
        TreeNode<String> expected4 = new TreeNode<>("task2");
        expected4.left = new TreeNode<>("task0");
        expected4.left.right = new TreeNode<>("task1");
        expected4.right = new TreeNode<>("task3");
        expected4.right.right = new TreeNode<>("task4");
        TreeNode<String> actual4 = TaskGenerator.generateTasks(4);
        assertTrue("Tree for n=4 does not match expected structure", treeEquals(expected4, actual4));
        assertTrue("Tree for n=4 should be balanced", isBalanced(actual4));

        // n = 5
        // Expected Tree:
        //      task2
        //     /     \
        //  task0    task4
        //     \     /   \
        //     task1 task3 task5
        TreeNode<String> expected5 = new TreeNode<>("task2");
        expected5.left = new TreeNode<>("task0");
        expected5.left.right = new TreeNode<>("task1");
        expected5.right = new TreeNode<>("task4");
        expected5.right.left = new TreeNode<>("task3");
        expected5.right.right = new TreeNode<>("task5");
        TreeNode<String> actual5 = TaskGenerator.generateTasks(5);
        assertTrue("Tree for n=5 does not match expected structure", treeEquals(expected5, actual5));
        assertTrue("Tree for n=5 should be balanced", isBalanced(actual5));
    }

    /**
     * Recursively compare two trees for structural and value equality.
     */
    private boolean treeEquals(TreeNode<String> tree1, TreeNode<String> tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (!tree1.value.equals(tree2.value)) {
            return false;
        }
        return treeEquals(tree1.left, tree2.left) && treeEquals(tree1.right, tree2.right);
    }

    /**
     * Check if tree is balanced (height difference <= 1 at every node)
     */
    private boolean isBalanced(TreeNode<String> root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode<String> node) {
        if (node == null) {
            return 0;
        }

        // verify the left tree is balanced
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        // verify the right tree is balanced
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        return (Math.abs(leftHeight - rightHeight) > 1) ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}