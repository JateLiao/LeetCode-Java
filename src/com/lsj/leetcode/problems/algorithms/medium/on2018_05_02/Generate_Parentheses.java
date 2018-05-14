package com.lsj.leetcode.problems.algorithms.medium.on2018_05_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


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
        System.out.println ("括号组成数量：" + pathes.size ());
        System.out.println ("所有括号组成：");
        for (String st : pathes) {
            System.out.println (st);
        }
    }
    
    private static final char LEFT_PATHE = '(';
    private static final char RIGHT_PATHE = ')';
    
    
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
        // Stack<Character> stack = new Stack<> ();
        for (int i = 1; i <= 2; i++) { // 左括号的开头序号：01；02，也就是12,13
            int centreCount = n - 2 - 1; //   中间需要处理的数量，末尾一位固定用来遍历
            char[] pthesArr = new char[len];
            pthesArr[0] = LEFT_PATHE;
            pthesArr[i] = LEFT_PATHE;
            if (centreCount == 0 || n == 3) { // 当n=3
                completePathes (parenthesis, pthesArr, i + 1, len - 2);
                fillRightPathes (pthesArr);
                continue;
            }
            for (int j = 0; j < n; j++) { // 3,4,
                int index = i + j + 1;
                char[] tmpArr = Arrays.copyOf (pthesArr, pthesArr.length);
                // 补充到倒数第二个位置
                int count = 0;
                do {
                    tmpArr[index] = LEFT_PATHE;
                    index++;
                } while (++count < centreCount);
                completePathes (parenthesis, tmpArr, index, len - 2);
            }
        }
        /************************************************************************************************************************/
        return parenthesis;
    }
    
    /**
     * 完成括号.
     * @param pthesList .
     * @param arr .
     * @param start .
     * @param end .
     */
    private static void completePathes(List<String> pthesList, char[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            char[] tmpArr = Arrays.copyOf (arr, arr.length);
            tmpArr[i] = LEFT_PATHE;
            if (tmpArr[tmpArr.length - 2] == LEFT_PATHE && tmpArr[tmpArr.length - 3] == LEFT_PATHE) {
                continue;
            }
            fillRightPathes (tmpArr);
            if (!isMatched (tmpArr)) {
                continue;
            }
            pthesList.add (String.valueOf (tmpArr));
        }
    }
    
    /**
     * 填充右括号.
     * @param arr arr.
     */
    private static void fillRightPathes(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == LEFT_PATHE ? LEFT_PATHE : RIGHT_PATHE;
        }
    }
    
    /**
     * 验证左右括号是否匹配:利用栈.
     * @param arr .
     * @return boolean:isMatched.
     */
    private static boolean isMatched(char[] arr) {
        Stack<Character> stack = new Stack<> ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == LEFT_PATHE) {
                stack.push (LEFT_PATHE);
            }
            if (arr[i] == RIGHT_PATHE) {
                if (stack.isEmpty ()) {
                    return false;
                }
                char element = stack.pop ();
                if (element != LEFT_PATHE) {
                    stack.push (RIGHT_PATHE);
                }
            }
        }
        
        if (!stack.isEmpty ()) {
            return false;
        }
        return true;
    }
}
