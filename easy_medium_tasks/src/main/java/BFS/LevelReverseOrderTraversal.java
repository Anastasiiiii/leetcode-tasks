package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelReverseOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrderBottom(root));
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            answer.add(0, level);
        }

        return answer;
    }
}
