package offer;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {
    /**
     *  从n的2进制形式的最右边开始判断是不是1
     * 该解法如果输入时负数会陷入死循环，因为负数右移时，
     * 在最高位补得是1二本题最终目的是求1的个数，那么会有无数个1了。
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }


    public double Power(double base, int exponent) {

        //由于exponent是int类型的整数，则可能包含正整数、0以及负整数三种情况。
        double temp=1;
        if(exponent > 0){
            for (int i = 1; i <= exponent; i++) {
                temp = temp * base;
                if (temp > 1.7976931348623157E308) {
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
            }
            return temp;

        }if(exponent < 0){
            exponent = -exponent;
            for (int i = 1; i <= exponent; i++) {
                temp = temp * base;
                if (temp > 1.7976931348623157E308) {
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
            }
            temp = 1.0 / temp;
            return temp;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
        //System.out.println(new Solution11().NumberOf1(-1));
        System.out.println(new Solution11().Power(1.1,2));
    }
}
