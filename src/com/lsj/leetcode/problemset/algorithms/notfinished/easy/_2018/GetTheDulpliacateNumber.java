package com.lsj.leetcode.problemset.algorithms.notfinished.easy._2018;

import com.lsj.leetcode.util.ArrayUtils;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.notfinished.easy.on2018_10_28
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/10/2811:28
 */
public class GetTheDulpliacateNumber {
    /**
     * 获取数组中的重复数字。
     * 在一个长度为n的数组里，所有数字都在0~n-1的范围内，
     * 数组内的某些数字是重复的，但不知道几个数字重复了，也不知道数字重复了几次；
     * 请找出数组内任意一个重复的数字。
     *
     * 例如：
     * 数组为：{0,5,1,2,6,9,8,4,5,3,2,4,1}
     * 那么输出的数字可为5,1,2
     *
     * 要求：时间复杂度：O(n)，空间复杂度：O(1)
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        int[] nums = {0, 5, 1, 2, 6, 9, 8, 4, 5, 3, 2, 4, 1};
        System.err.print("测试数据：" );
        ArrayUtils.showArrays(nums);
        long s = System.currentTimeMillis();
        int values = getTheDulplicateNumber(nums);
        System.err.println("结果：" + values);
        System.err.println("耗时：" + String.valueOf(System.currentTimeMillis() - s));
    }
    
    public static int getTheDulplicateNumber(int[] num_arr) {
        int value = num_arr[0];
        for (int i = 0, len = num_arr.length; i < len; i++) {
            //if ()
            
            
        }
        return value;
    }
}
