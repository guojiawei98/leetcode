package all;

/*
* 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
*/
public class ReverseWords2Demo {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            res.append(new StringBuilder(word).reverse()+" ");
        }
        return res.toString().trim();
    }

    //双指针，反转字符前后指针
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            int j = s.indexOf(' ', i + 1);
            if (j == -1) j = s.length();
            for (int k = j - 1; i < k ; i++, k--) {
                char t = chars[i];
                chars[i] = chars[k];
                chars[k] = t;
            }
            i = j + 1;
        }
        return String.valueOf(chars);
    }
}
