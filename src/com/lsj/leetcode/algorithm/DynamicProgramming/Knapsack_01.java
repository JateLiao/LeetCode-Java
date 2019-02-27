package com.lsj.leetcode.algorithm.DynamicProgramming;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.algorithm.DynamicProgramming
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/2/2722:45
 */
public class Knapsack_01 {
    /**
     * 01背包问题:
     * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，体积是w[i]。
     * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大?
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int[] w_arr = {2, 2, 6, 4, 5, 8}; // 价值
        int[] v_arr = {6, 3, 5, 4, 6, 2}; // 体积
        int n = 12;
        int val = dp_findMax(w_arr, v_arr, n);
        System.out.println("最大价值：" + val);
    }
    
    /**
     * 动态规划.
     */
    private static int dp_findMax(int[] w_arr, int[] v_arr, int n) {
        int i, w = 0;
        int len = w_arr.length;
        int[][] rv = new int[len + 1][n + 1];
        for (i = 0; i <= len; i++) {
            for (w = 0; w <= n; w++) {
                if (i == 0 || w == 0) { // 初始出口条件
                    rv[i][w] = 0;
                } else if (w_arr[i - 1] <= w) { // 背包空间足够，可以选择拿 或者 不拿，但是要拿价值最大的那个
                    rv[i][w] = Math.max(v_arr[i - 1] + rv[i - 1][w - w_arr[i - 1]], rv[i - 1][w]);
                } else { // 背包空间不足，选择不拿
                    rv[i][w] = rv[i - 1][w]; // 和上一次选择保持一致，相当于跳过这次选择
                }
                
            }
        }
        
        int max = rv[len][w - 1];
        return max;
    }
    
}
