package LinkedList;

public class ShuffleList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode rotatedList = rotateRight(head, 2);
        while (rotatedList != null) {
            System.out.println(rotatedList.value + " ");
            rotatedList = rotatedList.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        int rotations = k % length;
        current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;

        int newTailPosition = length - rotations - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
