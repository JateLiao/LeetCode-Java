package com.lsj.leetcode.problemset.algorithms.hard.on2018_07_13;

import java.util.List;

/**
 * @Desc PalindromePairs
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/7/13 10:33
 * @Author tianzhong
 */
public class PalindromePairs {
    /**
     * 336. 回文对
     *
     * 给定一组独特的单词， 找出在给定列表中不同 的索引对(i, j),使得关联的两个单词，例如：words[i] + words[j]形成回文。
 
     示例 1:
     给定 words = ["bat", "tab", "cat"]
     返回 [[0, 1], [1, 0]]
     回文是 ["battab", "tabbat"]
 
     示例 2:
     给定 words = ["abcd", "dcba", "lls", "s", "sssll"]
     返回 [[0, 1], [1, 0], [3, 2], [2, 4]]
     回文是 ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 
     贡献者:
     特别感谢 @dietpepsi 添加这个问题并提供所有的测试用例。
 
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        String[] str = {"", ""};
        System.err.println("测试数据：" + str.length);
        long s = System.currentTimeMillis ();
        List<List<Integer>> values = new PalindromePairs ().palindromePairs (str);
        System.err.println("结果：");
        for (List<Integer> val: values) {
            System.out.println(val);
        }
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        return null;
    }
}
