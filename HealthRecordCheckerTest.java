import org.junit.Test;
import static org.junit.Assert.*;

public class HealthRecordCheckerTest {

    @Test
    public void testEmptyList() {
        ListNode head = null;
        assertTrue("An empty list should be symmetric", HealthRecordChecker.isHealthRecordSymmetric(head));
    }

    @Test
    public void testSingleElementList() {
        ListNode head = new ListNode(1);
        assertTrue("A single element list should be symmetric", HealthRecordChecker.isHealthRecordSymmetric(head));
    }

    @Test
    public void testSymmetricListEvenCount() {
        // List: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        assertTrue("A symmetric list with even count should be symmetric", HealthRecordChecker.isHealthRecordSymmetric(head));
    }

    @Test
    public void testSymmetricListOddCount() {
        // List: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        assertTrue("A symmetric list with odd count should be symmetric", HealthRecordChecker.isHealthRecordSymmetric(head));
    }

    @Test
    public void testNonSymmetricListEvenCount() {
        // List: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        assertFalse("A non-symmetric list with even count should not be symmetric", HealthRecordChecker.isHealthRecordSymmetric(head));
    }

    @Test
    public void testNonSymmetricListOddCount() {
        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        assertFalse("A non-symmetric list with odd count should not be symmetric", HealthRecordChecker.isHealthRecordSymmetric(head));
    }
}
