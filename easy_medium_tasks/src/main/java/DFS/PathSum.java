package DFS;

import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(hasPathSum(root, 3));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();

        stack.push(root);
        values.push(root.val);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            int currentSum = values.pop();

            if(current.left == null && current.right == null && currentSum == targetSum){
                return true;
            }

            if(current.right != null) {
                stack.push(current.right);
                values.push(currentSum + current.right.val);
            }

            if(current.left != null) {
                stack.push(current.left);
                values.push(currentSum + current.left.val);
            }
        }

        return false;
    }
}
