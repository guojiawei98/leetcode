public class FlattenDemo {
    /*
    * 扁平化多级双向链表
您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。

示例:
输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL*/

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
                //break 再循环中的作用是 跳出一个循环或者结束一个循环
                //continue 立即结束本次循环，继续执行下一次循环。
            }
            Node tmp = p.child;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = p.next;
            if (p.next != null) {
                p.next.prev = tmp;
            }
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node() {}
    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}