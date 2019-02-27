package com.lsj.leetcode.algorithm.DynamicProgramming;

import com.lsj.leetcode.util.ArrayUtils;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.algorithm.DynamicProgramming
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/2/2710:05
 */
public class BiggestSum {
    /**
     * 求不相邻的数字加起来的最大值.
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int[] arr_value = {1, 2, 4, 1, 7, 8, 3};
        System.out.println("递归：" + rec_opt(arr_value, 6));
        System.out.println("非递归：" + dp_opt(arr_value));
    }
    
    /**
     * 递归解法.
     * @param arr 数组.
     * @param index 第index个.
     * @return value.
     */
    public static int rec_opt(int[] arr, int index) {
        if (index == 0) {
            return arr[0];
        } else if (index == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            return Math.max(rec_opt(arr, index - 2) + arr[index], rec_opt(arr, index - 1));
        }
    }
    
    /**
     * 非递归（动态规划）.
     * @param arr arr.
     * // @ param index inx.
     * @return value.
     */
    public static int dp_opt(int[] arr) {
        int[] value_arr = new int[arr.length];
        
        value_arr[0] = arr[0];
        value_arr[1] = Math.max(arr[1], arr[0]);
        
        for (int i = 2; i < arr.length; i++) {
            value_arr[i] = Math.max(value_arr[i - 2] + arr[i], value_arr[i - 1]);
        }
    
        ArrayUtils.showArrays(value_arr);
        
        return value_arr[value_arr.length - 1];
    }
}
