package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal2(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }

        return result;
    }

    //Recursive
    private static List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorderHelp(root, result);
        return result;
    }

    private static void inorderHelp(TreeNode node, List<Integer> result){
        if(node == null) return;

        inorderHelp(node.left, result); //Left
        result.add(node.val); //Root
        inorderHelp(node.right, result); //Right
    }
}
