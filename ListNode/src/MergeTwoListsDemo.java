public class MergeTwoListsDemo {
    /*
    * 合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4*/

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    //普通迭代方法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode firstNode = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        while (l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return firstNode.next;
    }

    //递归方法
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = null;
        if (l1.val < l2.val) {
            temp = l1;
            temp.next = mergeTwoLists3(l1.next, l2);
        } else {
            temp = l2;
            temp.next = mergeTwoLists3(l1, l2.next);
        }
        return temp;
    }
}
