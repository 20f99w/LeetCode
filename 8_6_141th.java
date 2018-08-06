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
 //这个是two point方法，下次试试hashmap法
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode a=head;
        ListNode b=head.next;
        while(a!=b){
            if(b==null||b.next==null) return false;
            a=a.next;
            b=b.next.next;
        }
        return true;
    }
}
