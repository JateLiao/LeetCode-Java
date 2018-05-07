package com.lsj.leetcode.problems.algorithms.medium.on2018_05_02;

import java.util.ArrayList;
import java.util.List;


/**
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * ["((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"]
 */
public class Generate_Parentheses {
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        List<String> pathes = generateParenthesis (3);
        System.out.println("所有括号组成：");
        for (String st : pathes) {
            System.out.println(st);
        }
    }
    
    private static  final char LEFT_PATHE = '(';
    private static  final char RIGHT_PATHE = ')';
    
    
    /**
     * 1.从左至右，连续的左括号数递增
     * 2.所有左括号出现的位置遍历，其他位置补右括号
     *   2.1 需要每个左括号之间相隔的空位数量，是2的倍数，可为0
     *   2.2 第一个只能为左括号，最后一个只能为右括号，且不能最后为两个连续的左括号紧接着最后的有括号
     *   2.3 1到n-1；从1开始，到2到3，
     *   2.4 左括号开头
     */
    public static List<String> generateParenthesis(int n) {
        if (n < 1) {
            return null;
        }
        List<String> parenthesis = new ArrayList<> ();
        if (n == 1) {
            parenthesis.add ("()");
            return parenthesis;
        }
        if (n == 2) {
            parenthesis.add ("()()");
            parenthesis.add ("(())");
            return parenthesis;
        }
        
        int len = n * 2;
        int[] idxArr = new int[len];
        for (int i = 0; i < len; i++) {
            idxArr[i] = i;
        }
        int leftCount = 0; // 左括号数
    
        for (int i = 1; i <= 2; i++) { // 左括号的开头序号：01；02，也就是12,13
            leftCount = 2;
            int count = 2;
            int startIdx = i + 1;
            int leftCapacity = n - 2; // 剩余的空间

            // 有多少层循环，取决于n
            do {
                for (int j = startIdx; j < len; j++) {
                    char[] pthesArr = new char[len];
                    pthesArr[0] = LEFT_PATHE;
                    pthesArr[i] = LEFT_PATHE;
                    pthesArr[j] = LEFT_PATHE;
                    startIdx++;
                    // leftCapacity--;
                    if (++leftCount >= n) {
                        leftCount = 2;
                        fillRightPathes(pthesArr);
                        parenthesis.add (String.valueOf (pthesArr));
                        break;
                    }
                }
                leftCapacity--;
            } while(count <= n && leftCapacity > 0);
            
//            for (int j = i + 1; j < len - 1; j++) {
//                if (pthesArr[len -2] == LEFT_PATHE && pthesArr[len -3] == LEFT_PATHE) { // 过滤不符合的组合：不能最后为两个连续的左括号紧接着最后的有括号
//                    continue;
//                }
//
//                if (++leftCount == n) { // 填充右括号
//                    fillRightPathes(pthesArr);
//                    parenthesis.add (String.valueOf (pthesArr));
//                    break;
//                }
//            }
        }
        
        return parenthesis;
    }
    
    private static void  fillRightPathes(char[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == LEFT_PATHE ? LEFT_PATHE : RIGHT_PATHE;
        }
    }
}
