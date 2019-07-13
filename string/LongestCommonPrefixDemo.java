package string;
/*
* 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
*/
public class LongestCommonPrefixDemo {
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String prefix = "";

        if(count != 0){
            prefix = strs[0];
        }
        for (int i = 0; i < count; i++) {
            //关键代码，不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
