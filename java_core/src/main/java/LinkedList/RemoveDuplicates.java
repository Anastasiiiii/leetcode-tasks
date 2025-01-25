package LinkedList;

import java.util.HashSet;


public class RemoveDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(5);

        head = removeDuplicates(head);
        while (head != null) {
            System.out.println(head.value + " ");
            head = head.next;
        }
    }

    private static ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        HashSet<Integer> set = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
            } else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }
}
