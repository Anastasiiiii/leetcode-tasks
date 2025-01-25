package BinaryTree;

import static BinaryTree.Main.inorderTraversal;

public class ReverseTree {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(5,
                new TreeNode(4, new TreeNode(3), new TreeNode(6)),
                new TreeNode(2, new TreeNode(1), new TreeNode(7))
        );
        reverseTree(root3);
        System.out.println(inorderTraversal(root3));
    }

    private static TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        preorderHelper(root);

        return root;
    }

    private static void preorderHelper(TreeNode node){
        if(node == null){
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        preorderHelper(node.left);
        preorderHelper(node.right);

    }
}
