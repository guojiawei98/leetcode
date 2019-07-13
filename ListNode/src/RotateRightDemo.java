public class RotateRightDemo {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //获取链表长度，并得到尾节点的指针
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }

        k = k % len;//去除需要多旋转的圈数
        p.next = head;//将链表首尾相连，结成环形
        for (int i = 0; i < len - k; i++) {
            p = p.next;//旋转链表
        }
        head = p.next;//新的链表头
        p.next = null;//断开环形链表
        return head;
    }
}
