package com.lsj.leetcode.problems.algorithms.medium.on2018_05_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problems.algorithms.medium.on2018_05_02
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/5/223:26
 */
public class Generate_Parentheses {
    /**
     * 括号生成
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 例如，给出 n = 3，生成结果为：
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        List<String> pathes = generateParenthesis (1);
        System.out.println("所有括号组成：");
        for (String st : pathes) {
            System.out.println(st);
        }
    }
    
    public static List<String> generateParenthesis(int n) {
        if (n < 1) {
            return null;
        }
        List<String> parenthesis = new ArrayList<> ();
        if (n == 1) {
            parenthesis.add ("()");
            return parenthesis;
        }
        
        /**
         *
         * 隐约觉得要用到递归
         * 1.从左至右，连续的左括号数递增
         * 2.所有左括号出现的位置遍历，其他位置补右括号
         *   2.1 需要每个左括号之间相隔的空位数量，是2的倍数，可为0
         *   2.2 第一个只能为左括号，最后一个只能为右括号
         *   2.3 1到n-1；
         */
        
        int len = n * 2;
        int leftCount = 0; // 左括号数
        String[] pthesArr = new String[len];
        for (int i = 0; i < n; i++) {
        
        }
        
        return parenthesis;
    }
}
