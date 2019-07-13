package all;
/*
* 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 3
输出: [1,3,3,1]

进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？
*/

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.List;

public class GetRowDemo {
    public static void main(String[] args) {
        List<Integer> list = getRow(4);
        System.out.println(list);
    }
    public static List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            for (int j = i; j > 0; j--) {
                res[j] += res[j - 1];
            }
        }
        return Arrays.asList(res);
    }
}
