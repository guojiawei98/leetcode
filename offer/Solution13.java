package offer;

/**调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {

    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0 ||array.length == 1)
            return;

        //类似与插入排序（稳定性）
        //首先找到一个奇数，用temp存放这个数，空出来一个位置
        //然后，向前寻找一个偶数，如果是偶数，往后移位；如果不是偶数，则将temp放在这个位置之后
        for(int i=1; i<array.length; i++){
            if (array[i] % 2 == 1) {
                int k = i - 1;
                int temp = array[i];
                while (k >= 0 && array[k] % 2 == 0) {
                    array[k + 1] = array[k];
                    k--;
                }
                array[k + 1] = temp;
            }
        }

    }
}
