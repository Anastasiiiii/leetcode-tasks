package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    public static void main(String[] args) {

    }

    private static Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if(prev != null){
                    prev.next = curr;
                }

                prev = curr;

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }

        return root;
    }
}
