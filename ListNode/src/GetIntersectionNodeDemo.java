class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }
}
public class GetIntersectionNodeDemo {
    // 相交链表
    //编写一个程序，找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //先计算两个链表各自的长度
        //然后，让长链表先走两个链表之差，然后一起走，判断：两个节点相等时（相交并返回此节点），走完没相同节点（返回null）
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }
        }else {
            for (int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }

        //判断边界
        while (tempA != null && tempB != null) {
            if (tempA != tempB) {
                tempA = tempA.next;
                tempB = tempB.next;
                //tempA == tempB时返回tempA
            } else
                return tempA;
        }
        return null;
    }
}
