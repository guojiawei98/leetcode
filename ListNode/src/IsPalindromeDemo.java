public class IsPalindromeDemo {
    /*
    * 回文链表
请判断一个链表是否为回文链表。

示例 1:
输入: 1->2
输出: false

示例 2:
输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？*/
    public boolean isPalindrome(ListNode head) {
        //复制一份链表，并反转
        if (head == null) return true;
        ListNode node = head;
        ListNode tmp = null;
        while (node != null) {
            ListNode tmpNode = new ListNode(node.val);
            tmpNode.next = tmp;
            tmp = tmpNode;
            node = node.next;
        }
        //依次对比节点元素值
        while (tmp != null) {
            if (tmp.val != head.val) {
                return false;
            }
            head = head.next;
            tmp = tmp.next;
        }
        return true;
    }


    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null) {
            if (slow.val == fast.next.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || slow.val == fast.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
    }
}
