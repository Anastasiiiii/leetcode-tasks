package BinaryTree;

public class FindMinMethods {
    private static Integer second_minimum_in_tree(TreeNode root) {
        // TODO: implement the function
        if (root == null) {
            return null;
        }

        int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        inorderHelper(root, mins);

        return mins[1] == Integer.MAX_VALUE ? null : mins[1];
    }

    private static void inorderHelper(TreeNode node, int[] mins){
        if(node == null){
            return;
        }

        inorderHelper(node.left, mins);
        if (node.value < mins[0]){
            mins[1] = mins[0];
            mins[0] = node.value;
        } else if(node.value > mins[0] && node.value < mins[1]){
            mins[1] = node.value;
        }
        inorderHelper(node.right, mins);
    }

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(5,
                new TreeNode(4, new TreeNode(3), new TreeNode(6)),
                new TreeNode(2, new TreeNode(1), new TreeNode(7))
        );

        System.out.println(second_minimum_in_tree(root3));
    }
}
