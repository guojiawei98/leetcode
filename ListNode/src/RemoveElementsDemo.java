public class RemoveElementsDemo {
    /*
    * 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
*/
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        //定义虚拟头节点，为了方便头部删除元素
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode result = temp;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return result.next;
    }

    //递归解法
    /*public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);//从后往前删除元素，压栈入栈
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }*/
}
