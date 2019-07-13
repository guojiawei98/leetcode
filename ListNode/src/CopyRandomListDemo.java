import java.util.HashMap;

public class CopyRandomListDemo {
    class Node{
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    /*
    * 复制带随机指针的链表
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的深拷贝。

示例：
输入：
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

解释：
节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。

提示：
你必须返回给定头的拷贝作为对克隆列表的引用。*/
    public Node copyRandomList(Node head) {
        //使用HashMap
        HashMap<Node,Node> map = new HashMap<>();
        Node p = head;
        /*第一步，将原链表从头遍历，然后将每个节点深拷贝一份(这里的深拷贝意思：
        创建一个新的节点，里面的值用原节点的值一样)，然后将这个新的节点放入哈希
        表中，其中key为原节点，value为新的节点；
        * */
        while (p != null) {
            Node newListNode = new Node();
            newListNode.val = p.val;
            map.put(p,newListNode);
            p = p.next;
        }

        /*第二步，从头再遍历原链表，每次遍历从哈希表中取以当前节点为key的新节点，
        获得新的节点之后，新的节点的next为当前节点的next为key的新节点，新的节点的
        random也是如此。*/
        p = head;
        while (p != null) {
            //获取以当前的原节点为key的新节点
            Node q = map.get(p);
            //新节点的next
            q.next = map.get(p.next);
            //新节点的random
            q.random = map.get(p.random);
            p = p.next;
        }
        return map.remove(head);
    }


    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        //第一步，将原节点的next指向对应的新节点
        //新节点的next指向原节点的原next
        while (p != null) {
            Node newP = new Node(p.val,null,null);
            newP.next = p.next;
            p.next = newP;
            p = newP.next;
        }
        //第二步，参照原节点的random指向，改变新节点的random指向
        p = head;
        while (p != null) {
            //p.next 就是当前节点对应的新节点
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        //第三步，恢复
        Node newHead = head.next;
        p = head;
        Node q = newHead;
        while (p != null) {
            p.next = q.next;
            if (q.next != null) {
                q.next = q.next.next;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}