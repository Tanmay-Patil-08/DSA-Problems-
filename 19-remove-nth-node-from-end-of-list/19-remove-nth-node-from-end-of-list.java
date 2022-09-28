/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null && n == 1 ){
                return null;
        }
        
        ListNode c1 = head;
        ListNode c2 = head;
        
        for(int i = 1 ; i < n ;i++ ){
            c2 = c2.next;
        }
        ListNode pre = null;
        
        while(c2.next != null ){
            pre = c1;
            c2 = c2.next;
            c1 = c1.next;
            
        }
        if (pre == null ){
            return c1.next;
        }
        else {
        pre.next = c1.next;
          }
        return head ;
        
        
        
    }
}