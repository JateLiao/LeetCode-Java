package com.lsj.leetcode.problemset.algorithms.finished.medium.on2018_05_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.finished.medium.on2018_05_02
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/2/2716:07
 */
public class GP_on2019_02_27 {
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int n = 10;
        List<String> pathes = generateParenthesis(n);
        System.out.println("对数：" + n);
        System.out.println("括号组成数量：" + pathes.size());
        System.out.println("所有括号组成：");
        for (String st : pathes) {
            System.out.println(st);
        }
    }
    
    private static final char LEFT_PATHE = '(';
    private static final char RIGHT_PATHE = ')';
    
    
    /**
     * generateParenthesis.
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        rec_generateParenthesis(n, n, "", list);
        return list;
    }
    
    /**
     * rec_generateParenthesis.
     */
    private static void rec_generateParenthesis(int left, int right, String out, List<String> res) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(out);
        } else {
            if (left > 0) {
                rec_generateParenthesis(left - 1, right, out + LEFT_PATHE, res);
            }
            if (right > 0) {
                rec_generateParenthesis(left, right - 1, out + RIGHT_PATHE, res);
            }
        }
    }
}
