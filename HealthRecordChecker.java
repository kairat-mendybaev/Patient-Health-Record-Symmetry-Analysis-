class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class HealthRecordChecker {

    public static boolean isHealthRecordSymmetric(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Check for palindrome
        ListNode left = head;
        ListNode right = prev; // Start from the reversed half
        while (right != null) { // Only need to check the second half
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Is the health record symmetric? " + isHealthRecordSymmetric(head));
    }
}
