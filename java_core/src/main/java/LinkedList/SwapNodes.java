package LinkedList;

public class SwapNodes {
    /*
    You are given a singly linked list and two indices, start and end (both indices are 0-based).
    Write a Java function swapLinkedListNodes(ListNode head, int start, int end) that swaps the nodes of the linked list at these two provided indices.
    The function should return the head node of the modified linked list. When swapping, you should only change the next property of a node, not the actual node values.
    It is guaranteed that start <= end.
     */

    private static ListNode swapLinkedListNodes(ListNode head, int start, int end) {
        if (head == null || start == end) {
            return head;
        }

        ListNode startNode = head;
        ListNode prevStart = null;
        ListNode endNode = head;
        ListNode prevEnd = null;
        int index = 0;

        while (index != start) {
            prevStart = startNode;
            startNode = startNode.next;
            index++;
        }

        index = 0;
        while (index != end) {
            prevEnd = endNode;
            endNode = endNode.next;
            index++;
        }

        swap(startNode, prevStart, endNode, prevEnd);

        if(start == 0){
            head = endNode;
        }

        return head;
    }

    private static void swap(ListNode startNode, ListNode prevStart, ListNode endNode, ListNode prevEnd) {
        if (startNode == endNode) {
            return;
        }

        //If nodes are adjacent
        if (startNode.next == endNode) {
            startNode.next = endNode.next;
            endNode.next = startNode;
            if (prevStart != null) {
                prevStart.next = endNode;
            }
        } else {
            ListNode temp = startNode.next;
            startNode.next = endNode.next;
            endNode.next = temp;
            if (prevStart != null) {
                prevStart.next = endNode;
            }

            if (prevEnd != null) {
                prevEnd.next = startNode;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = swapLinkedListNodes(head, 1, 3);
        while (head != null){
            System.out.println(head.value + " ");
            head = head.next;
        }
    }
}
