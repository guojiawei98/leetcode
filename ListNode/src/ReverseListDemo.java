public class ReverseListDemo {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    * 反转链表
    反转一个单链表。

    示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL

    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
    */
    public ListNode reverseList(ListNode head) {
        //迭代方式
        /*
        * 非递归实现，模拟的是基本的手动操作， 访问链表中的每一个节点，
        * 但是同时要记住当前被访问节点的上一个和下一个节点。这三个指针
        * 构成了一个滑动的窗口，当前的值是滑动窗口的中心，上一个节点最终会变成新链表的头节点。*/
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;//temp临时指针存放其地址
            cur.next = newHead;//然后再让cur.next指向newHead，最后cur=temp就可以取回原链表的数据了
            newHead = cur;
            cur = temp;
        }
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        //递归方法。
        if (head == null) {
            return null;
        }
        if (head.next == null) {//链表为空直接返回，而head.next为空是递归的基线条件
            return head;
        }
        ListNode newHead = reverseList1(head.next);//一直到链尾，使得newHead = 链尾节点
        head.next.next = head;//将head地址赋给head.next.next 反转链表指向
        head.next = null;//记得赋值NULL，防止链表错乱，断开连接
        return newHead;
    }


}