package offer;

public class Solution4 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
/*题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如
输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null)
            return null;

        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn){

        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root=new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]){
                //endPre = startPre + 左子树元素个数
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+(i-startIn),in,startIn,i-1);
                //startPre = startPre + 右子树元素个数 + 1
                root.right = reConstructBinaryTree(pre,startPre+(i-startIn)+1,endPre, in,i+1,endIn);
            }
        }
        return root;
    }
}
