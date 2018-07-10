package com.lsj.leetcode.problemset.algorithms.hard.on2018_07_10;

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
        String str = "";
        System.err.println("测试数据：" + str);
        long s = System.currentTimeMillis ();
        String values = new RemoveDuplicateLetters ().removeDuplicateLetters (str);
        System.err.println("结果：" + values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public String removeDuplicateLetters(String s) {
        return null;
    }
}
