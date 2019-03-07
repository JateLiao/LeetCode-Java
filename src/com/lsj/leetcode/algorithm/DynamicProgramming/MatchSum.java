package com.lsj.leetcode.algorithm.DynamicProgramming;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.algorithm.DynamicProgramming
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/2/2711:26
 */
public class MatchSum {
    /**
     * 在一个数组内找个一组数字，使得这几个数字之和等于给定值，
     * 如果这个数组满足这么一组字，返回true，否则返回false；
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println("递归结果: " + rec_subset(arr, target));
        System.out.println("非递归结果: " + dp_subset(arr, target));
    }
    
    /**
     * 非递归.
     * @param arr arr.
     * @param sum sum.
     * @return true/false.
     */
    public static boolean rec_subset(int[] arr, int sum) {
        return rec_subset(arr, arr.length - 1, sum);
    }
    
    /**
     * 递归.
     * @param arr arr.
     * @param sum sum.
     * @param i index.
     * @return true/false.
     */
    public static boolean rec_subset(int[] arr, int i, int sum) {
        if (sum == 0) {
            return true;
        } else if (i == 0) {
            return arr[0] == sum;
        } else if (arr[i] > sum) {
            //return false;
            return rec_subset(arr, i - 1, sum);
        } else {
            boolean a = rec_subset(arr, i - 1, sum - arr[i]);
            boolean b = rec_subset(arr, i - 1, sum);
            return a || b;
        }
    }
    
    /**
     * 非递归.
     * @param arr arr.
     * @param sum sum.
     * @return true/false.
     */
    public static boolean dp_subset(int[] arr, int sum) {
        int[][] val_arr = new int[arr.length][arr.length];
        
        
        return false;
    }
    
}
