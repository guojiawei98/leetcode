package SingleListNode;
/*
*
添加操作 - 单链表

如果我们想在给定的结点 prev 之后添加新值，我们应该：
使用给定值初始化新结点 cur；
将 cur 的“next”字段链接到 prev 的下一个结点 next；
将 prev 中的“next”字段链接到 cur 。
与数组不同，我们不需要将所有元素移动到插入元素之后。因此，您可以在 O(1) 时间复杂度中将新结点插入到链表中。

示例
让我们在第二个结点 6 之后插入一个新的值 9。
我们将首先初始化一个值为 9 的新结点。然后将结点 9 链接到结点 15。最后，将结点 6 链接到结点 9。



在开头添加结点

众所周知，我们使用头结点来代表整个列表。
因此，在列表开头添加新节点时更新头结点 head 至关重要。
初始化一个新结点 cur；
将新结点链接到我们的原始头结点 head。
将 cur 指定为 head。
例如，让我们在列表的开头添加一个新结点 9。
我们初始化一个新结点 9 并将其链接到当前头结点 23。
指定结点 9 为新的头结点。



删除操作 - 单链表

在我们的第一步中，我们需要找出 prev 和 next。使用 cur 的参考字段很容易找出 next，
但是，我们必须从头结点遍历链表，以找出 prev，它的平均时间是 O(N)，其中 N 是链表的长度。
因此，删除结点的时间复杂度将是 O(N)。空间复杂度为 O(1)，因为我们只需要常量空间来存储指针。
 */
public class ListNode {
    //设计链表
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;

    }

    /**
     * Initialize your data structure here.
     */
    class MyLinkedList {
        //head是一个特殊的节点，不含数据
        ListNode head = null;
        public MyLinkedList() {
            head = new ListNode(0);
        }


        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            //cur当前节点
            ListNode cur = head.next;
            int num = -1;
            while (cur != null) {
                num++;
                if (num == index) {
                    return cur.val;
                }
                cur = cur.next;
            }
            return -1;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        //创建一个新节点，初始化一个新结点 node；
        //将新结点链接到我们的原始头结点 head。
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = head.next;
            head.next = node;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            //从头指针开始，并head不含数据，所以num从-1开始
            ListNode cur = head;
            int num = -1;
            while (cur != null) {
                num++;
                if (num == index) {
                    ListNode node = new ListNode(val);
                    node.next = cur.next;
                    cur.next = node;
                }
                cur = cur.next;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            ListNode cur = head;
            int num = -1;
            while (cur.next != null) {
                num++;
                if(num == index){
                    ListNode temp = cur.next;
                    cur.next = temp.next;
                    break;
                }
                cur = cur.next;
            }
        }
    }
}