package array;
/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
  最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
  你可以假设除了整数 0 之外，这个整数不会以零开头。

  分析：
    1.末尾为9时，需要进位 例：19
    2.末尾和中间位都需要进位 例：199
    3.全部为9，全需要进位 例：999

  要点：
    1.首位也要判断 （i=0）时
    2.定义一个整形数组，默认值为0
  */
public class PlusOneDemo {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }else if (digits[i] == 9){
                digits[i] = 0;
            }
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
