package BinaryTree;

public class BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        System.out.println(isBinarySearchTree(root));
    }

    private static boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        return helper(root.left, minValue, root.value) && helper(root.right, root.value, maxValue);
    }
}
