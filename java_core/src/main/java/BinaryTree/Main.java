package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

    public class Main {

    //Inorder traversal method: left, root, right
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }

        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    //postorder traversal method: left, right root
    private static List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }

    private static void postOrderHelper(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }

        postOrderHelper(node.left, result);
        postOrderHelper(node.right, result);
        result.add(node.value);
    }

    //preorder traversal method: root, left, right
    private static List<Integer> preorder(TreeNode node){
        List<Integer> result = new ArrayList<>();
        preorderHelper(node, result);
        return result;
    }

    private static void preorderHelper(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }

        result.add(node.value);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(3), null));
        System.out.println(inorderTraversal(root));

        TreeNode root1 = new TreeNode(1,
                new TreeNode(4, new TreeNode(6), new TreeNode(7)),
                new TreeNode(3, new TreeNode(8), new TreeNode(2))
        );

        TreeNode root2 = new TreeNode(5,
                new TreeNode(4, new TreeNode(3), new TreeNode(6)),
                new TreeNode(2, new TreeNode(1), new TreeNode(7))
        );
        System.out.println(postOrder(root1));
        System.out.println(preorder(root1));
        System.out.println(inorderTraversal(root2));
    }
}
