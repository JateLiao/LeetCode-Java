package com.lsj.leetcode.problemset.algorithms.notfinished.hard.on2018_09_10;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.notfinished.hard.on2018_09_10
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/9/100:11
 */
public class NumberOfDigitOne {
    /**
     * 233
     * URL：https://leetcode-cn.com/problems/number-of-digit-one/description/
     *
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     * 示例:
     * 输入: 13
     * 输出: 6
     * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        int n = 445;
        System.err.println("测试数据：" + n);
        long s = System.currentTimeMillis();
        int values = new NumberOfDigitOne().countDigitOne(n);
        System.err.println("结果：" + values);
        System.err.println("耗时：" + String.valueOf(System.currentTimeMillis() - s));
    }
    
    public int countDigitOne(int n) {
        return 0;
    }
}
