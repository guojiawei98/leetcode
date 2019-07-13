package doubleArray;

import java.util.ArrayList;
import java.util.List;

//螺旋遍历二维数组
//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
public class SpiralOrderDemo {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int r = 0, m = matrix.length - 1;
        int c = 0, n = matrix[0].length - 1;

        while (r <= m && c <= n) {
            for (int i = c; i <= n; i++)
                list.add(matrix[r][i]);

            for (int j = r + 1; j <= m; j++)
                list.add(matrix[j][n]);

            if (r < m && c < n) {
                for (int i = n - 1; i > c; i--)
                    list.add(matrix[m][i]);

                for (int j = m; j > r; j--)
                    list.add(matrix[j][c]);
            }
            r++;
            m--;
            c++;
            n--;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
