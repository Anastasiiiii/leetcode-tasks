package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p, q));

    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()){
            TreeNode node1 = queueP.poll();
            TreeNode node2 = queueQ.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;

            queueP.add(node1.left);
            queueQ.add(node2.left);

            queueP.add(node1.right);
            queueQ.add(node2.right);

        }

        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
