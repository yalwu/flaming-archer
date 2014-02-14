/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class FindCycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null || head.next == null)
            return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow)
                break;            
            
        }
        
        if (fast==slow)
            return true;
        else
            return false;
        
    }
}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
