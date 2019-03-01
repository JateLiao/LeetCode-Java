package com.lsj.leetcode.algorithm.DynamicProgramming;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.algorithm.DynamicProgramming
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/3/110:29
 */
public class Fibonacci {
    /**
     * 斐波那契数列.
     */
    
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int n = 10;
        System.out.println("递归：" + rec_fib(n));
        System.out.println("动态规划：" + dp_fib(n));
        System.out.println("普通数组：" + arr_fib(n));
    }
    
    
    /**
     * 递归.
     */
    public static int rec_fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        
        return rec_fib(n - 1) + rec_fib(n - 2);
    }
    
    /**
     * 动态规划.
     */
    public static int dp_fib(int n) {
        int[] fib_arr = new int[n + 1];
        
        //if (n == 1 || n == 2) {
        //    return 1;
        //} else {
        //    dp_fib_arr(n, fib_arr);
        //}+0+`
    
        dp_fib_arr(n, fib_arr);
        
        return fib_arr[n];
    }
    
    private static int dp_fib_arr(int n, int[] arr) {
        if (n <= 0) {
            return 0;
        }
        
        if (arr[n] != 0) { // 已经计算过就直接返回
            return arr[n];
        }
        
        if (n <= 2) { // 前两位
            arr[n] = 1;
        } else {
            arr[n] = dp_fib_arr(n - 1, arr) + dp_fib_arr(n - 2, arr);
        }
        
        
        return arr[n];
    }
    
    /**
     * 普通数组.
     */
    public static int arr_fib(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        
        return arr[n - 1];
    }
}
