package com.lsj.leetcode.problemset.algorithms.easy.on2018_07_04;

/**
 * @Desc CountPrimes
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/7/4 14:13
 * @Author tianzhong
 */
public class CountPrimes {
    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * 示例:
     *  输入: 10
     *  输出: 4
     *  解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     
     /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        int num = 1;
        System.err.println("测试数字：" + num);
        long s = System.currentTimeMillis ();
        int values = new CountPrimes ().countPrimes (num);
        System.err.println("数量：" + values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public int countPrimes(int n) {
        return 0;
    }
}