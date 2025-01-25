package LinkedList;

class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class ReverseLinkedList {
    private static ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedList = reverseLinkedList(head);
        while (reversedList != null){
            System.out.println(reversedList.value + " ");
            reversedList = reversedList.next;
        }
    }
}
