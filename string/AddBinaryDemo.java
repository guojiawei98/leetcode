package string;
/*
*
    给定两个二进制字符串，返回他们的和（用二进制表示）。
    输入为非空字符串且只包含数字 1 和 0。

    示例 1:
    输入: a = "11", b = "1"
    输出: "100"

    示例 2:
    输入: a = "1010", b = "1011"
    输出: "10101"
*/
public class AddBinaryDemo {
    public String addBinary(String a, String b) {
        String result = "";
        int sum = 0;
        int lengthA = a.length();
        int lengthB = b.length();
        while (lengthA > 0 || lengthB > 0) {
            if (lengthA > 0) {
                //截取字符串最后一位，类似获取十进制里的个位
                sum += Integer.parseInt(a.substring(lengthA - 1, lengthA));
                lengthA--;
            }
            if (lengthB > 0) {
                sum += Integer.parseInt(b.substring(lengthB - 1, lengthB));
                lengthB--;
            }
            //当刚好满足二进制进位条件时
            if (sum == 2) {
                //相加刚好等于2，所以前一位剩余0，类似于十进制 4+6时，个位满十进位，个位数值为0
                result = "0" + result;
                //这里重新赋予1，是指进位的那一个数值，所以前面代码是用 sum+=  而不是sum=
                sum = 1;
            } else if (sum == 3) {
                result = "1" + result;
                sum = 1;
            } else {
                result = (sum + "") + result;
                sum = 0;
            }
        }
        //用于处理最高位进位
        if (sum == 1) {
            result = "1" + result;
        }
        return result;
    }
}
