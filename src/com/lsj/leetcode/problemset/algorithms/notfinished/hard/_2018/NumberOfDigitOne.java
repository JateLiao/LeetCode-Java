package com.lsj.leetcode.problemset.algorithms.notfinished.hard._2018;

import java.util.Random;
import java.util.UUID;

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
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        System.out.println(uuid.split("\\-")[0]);
        
        String randomTime = String.valueOf(System.currentTimeMillis() + (new Random().nextInt(10) + 1));
        System.out.println(randomTime);
        
        int n = 999999999;
        System.err.println("测试数据：" + n);
        long s = System.currentTimeMillis();
        int values = new NumberOfDigitOne().countDigitOne(n);
        System.err.println("结果：" + values);
        System.err.println("耗时：" + (System.currentTimeMillis() - s));
    }
    
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        long mod = 1;   // 记录置1的位置处于个位、十位、百位、千位等...
        int count = 0;  // 记录1的数量
        long front, back;
        long curDigit;     // 记录当前位置的数字
        while (mod <= n) {
            front = n / (mod * 10);  // 得到某一个位数置1后的商，即当前数之前的部分
            back = n % mod;          // 得到某一位数置1后的余数，即当前数之后的部分
            curDigit = (n / mod) % 10;  // 当前置1的位置原来(置1之前)的数
            
            if (curDigit > 1) {
                count += (front + 1) * mod; // 当前位置的数字>1时
            }
            if (curDigit == 1)   // 当前位置的数字=1时
            {
                count += (front * mod + back + 1);
            }
            if (curDigit == 0)   // 当前位置的数字=0时
            {
                count += front * mod;
            }
            mod *= 10;
        }
        return count;
    }
}
