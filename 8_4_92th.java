/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //我一开始想到将m以前的放入一个linknode然后从第m个起reverse，但我没法想出一个合适的交换，因为node=node.next这种类似逻辑根本没考虑过
    //我自己的思路没法实现，因为我不熟悉linklist的操作和套路
    //这个答案的逻辑太棒了
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); 
        dummy.next = head;
        ListNode pre = dummy; 
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; 
        ListNode then = start.next; 
        for(int i=0; i<n-m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
