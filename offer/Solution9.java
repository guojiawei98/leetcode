package offer;

import java.util.Arrays;

/*变态跳台阶
* 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。*/
public class Solution9 {
    public int JumpFloorII(int target) {

        if (target == 0)
            return 0;

        int[] memo = new int[target + 1];

        memo[0] = 1;
        memo[1] = 1;

        for(int i = 2 ; i <= target ; i ++) {
            //memo[i] = 0;
            for (int j = 0; j < i; j++) {
                memo[i] += memo[j];
            }
        }
        return memo[target];
    }

    /*矩形覆盖
    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？*/
    public int RectCover(int n) {
        if (n == 0)
            return 0;

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().JumpFloorII(5));
    }
}
