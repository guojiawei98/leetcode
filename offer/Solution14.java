package offer;

import java.util.List;

/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0)
            return null;
        ListNode first = head;
        ListNode last = head;
        int count = 0;
        while (last != null) {
            count++;
            last = last.next;
        }

        if (count < k) {
            return null;
        }

        for (int i = 0; i < count - k; i++) {
            first = first.next;
        }
        return first;
    }

    /**
     *输入一个链表，反转链表后，输出新链表的表头。（非递归）
     * @param head
     * @return 输出新链表的表头
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode newHead = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;//存数据
            cur.next = newHead;//改变指向
            newHead = cur;//指针后移
            cur = temp;//后移指针
        }
        return newHead;
    }

    /**
     *输入一个链表，反转链表后，输出新链表的表头。（递归）
     * @param head
     * @return 输出新链表的表头
     */
    public ListNode ReverseList1(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode newHead = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 合并两个排序的链表
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode temp = null;
        if (list1.val < list2.val) {
            temp = list1;
            temp.next = Merge(list1.next, list2);
        } else {
            temp = list2;
            temp.next = Merge(list1,list2.next);
        }
        return temp;
    }
}
