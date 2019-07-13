package offer;

import java.util.Stack;

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//队列：先进先出
// 栈：先进后出
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
/*
* 用两个栈实现一个队列的功能?要求给出算法和思路!
<分析>：
    入队：将元素进栈A
    出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；如果不为空，栈B直接出栈。*/
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if (stack1.empty() && stack2.empty())
            throw new RuntimeException("Queue is empty");

        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
