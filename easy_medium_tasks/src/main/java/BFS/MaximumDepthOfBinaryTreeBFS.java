package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTreeBFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int answer = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            answer++;
        }

        return answer;
    }
}
