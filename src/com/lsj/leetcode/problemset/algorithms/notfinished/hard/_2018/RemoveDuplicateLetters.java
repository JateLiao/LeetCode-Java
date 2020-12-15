package com.lsj.leetcode.problemset.algorithms.notfinished.hard._2018;

/**
 * @Desc RemoveDuplicateLetters
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/7/10 14:22
 * @Author tianzhong
 */
public class RemoveDuplicateLetters {
    /**
     * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     示例 1:
     输入: "bcabc"
     输出: "abc"
 
     示例 2:
     输入: "cbacdcbc"
     输出: "acdb"
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        String str = "ddbbacca";
        System.err.println("测试数据：" + str);
        long s = System.currentTimeMillis ();
        String values = new RemoveDuplicateLetters ().removeDuplicateLetters (str);
        System.err.println("结果：" + values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public String removeDuplicateLetters(String s) {
        String result = null;
        
        int[] charIndexArr = new int[26];
        char[] charArr = s.toCharArray();
        if (null != charArr && charArr.length > 0) {
            int len = charArr.length;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                char c = charArr[i];
                //int index = c;
                if (charIndexArr[c] == 1) { // 出现过
                
                } else {
                    stringBuilder.append(c);
                }
                
                
                charIndexArr[c] = 1; // 出现过的置1
            }
        }
        
        return result;
    }
    
    //public int[] ct;
    //
    //public String removeDuplicateLetters(String s) {
    //    ct = new int[26];
    //    return solve(s);
    //}
    //
    //public String solve(String s) {
    //    if (s == null || s.equals("")) {
    //        return "";
    //    }
    //    Arrays.fill(ct, 0);
    //    for (char cur : s.toCharArray()) {
    //        ++ct[cur - 'a'];
    //    }
    //    int i = 0;
    //    int pos = 0;
    //    for (; i < s.length(); ++i) {
    //        if (s.charAt(i) < s.charAt(pos)) {
    //            pos = i;
    //        }
    //        --ct[s.charAt(i) - 'a'];
    //        if (ct[s.charAt(i) - 'a'] == 0) {
    //            break;
    //        }
    //    }
    //    return s.charAt(pos) + solve(s.substring(pos + 1).replace("" + s.charAt(pos), ""));
    //}
}
