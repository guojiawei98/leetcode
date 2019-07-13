public class RemoveNthFromEndDemo {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 既然只允许遍历一次，且N一直有效，那么可以利用双指针解法（前指针、后指针），
        // 让前指针先走N步，再让两个在指针同时后移，直到前指针到达尾部，
        // 此时，后指针的下一个节点就是要被删除的节点了。
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null) {
            return head = head.next;
        }
        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        
        return head;
    }
}
