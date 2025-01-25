package LinkedList;

public class Palindrome {
    private static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Half Of the list is slow
        ListNode reversedHalf = reverseList(slow);
        while (reversedHalf != null){
            if (head != null && reversedHalf.value != head.value) {
                return false;
            }
            reversedHalf = reversedHalf.next;
            assert head != null;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;

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
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
