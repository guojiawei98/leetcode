public class HasCycleDemo {
    /*
    环形链表
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：tru解释：链表中有一个环，其尾部连接到第二个节点。
*/
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    //利用双指针，快慢指针，若fast == slow 时，说明有环
    public boolean hasCycle(ListNode head) {
        if(head == null|| head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //环形链表II 返回环的第一个节点
    //要点：当快慢指针重合的位置到环入口的距离 = 头节点到环入口的距离
    //首先，判断是否有环（利用快慢指针）
    //其次，利用 快慢指针重合的位置到环入口的距离 = 头节点到环入口的距离，两边同时开始走，再次重合就是环入口节点
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;

            }
        }
        if (fast == null||fast.next == null)
            return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
