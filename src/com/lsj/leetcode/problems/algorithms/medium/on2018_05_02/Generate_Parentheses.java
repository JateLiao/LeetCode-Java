package com.lsj.leetcode.problems.algorithms.medium.on2018_05_02;

import java.util.ArrayList;
import java.util.Arrays;
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
        int n = 5;
        List<String> pathes = generateParenthesis (n);
        System.out.println("括号组成数量：" + pathes.size ());
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
        /************************************************************************************************************************/
        int len = n * 2;
        for (int i = 1; i <= 2; i++) { // 左括号的开头序号：01；02，也就是12,13
            int centerCount = n - 2 - 1; // 中间需要处理的数量，末尾一位固定用来遍历
            int startIdx = i + 1;
            for (int j = 0; j < len - i - 1; j++) {
                int index = startIdx + j;
                int endIdx = index;
                
                char[] pthesArr = new char[len];
                pthesArr[0] = LEFT_PATHE;
                pthesArr[i] = LEFT_PATHE;
    
                for (int k = 0; k < centerCount; k++) {
                    endIdx = index + k;
                    // System.err.println(endIdx);
                    pthesArr[endIdx] = LEFT_PATHE;
                }
    
                for (int k = endIdx + 1; k < len - 1; k++) {
                    char[] tmpArr = Arrays.copyOf (pthesArr, len);
                    tmpArr[k] = LEFT_PATHE;
                    if (tmpArr[len - 3] == LEFT_PATHE && tmpArr[len - 2] == LEFT_PATHE) {
                        continue;
                    }
                    fillRightPathes(tmpArr);
                    parenthesis.add (String.valueOf (tmpArr));
                }
            }
        }
        /************************************************************************************************************************/
        return parenthesis;
    }
    
    private static void  fillRightPathes(char[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == LEFT_PATHE ? LEFT_PATHE : RIGHT_PATHE;
        }
    }
}
