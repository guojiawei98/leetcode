package offer;

import java.util.Arrays;

//斐波那契数列
public class Solution7 {
//记忆化搜索
    private int[] memo;
    public int Fibonacci(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo,-1);
        return ReFibonacci(n);
    }

    private int ReFibonacci(int n) {
        if(n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (memo[n] == -1)
            memo[n] = ReFibonacci(n-1) + ReFibonacci(n-2);
        return memo[n];
    }

    //DP
    public int Fibonacci2(int n) {

        if (n == 0)
            return 0;

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }
    public static void main(String[] args) {
        //System.out.println(new Solution7().Fibonacci(36));
        System.out.println(new Solution7().Fibonacci2(1));
    }
}
