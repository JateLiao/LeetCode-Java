package com.lsj.leetcode.problems.algorithms.medium.on2018_04_22;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problems.algorithms.medium.on2018_04_22
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/4/2211:42
 */
public class _3Sum_Closest {
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest (arr, target));
    }
    
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    
    /**
     *
     * @param nums nums.
     * @param target target.
     * @return 最接近的和.
     */
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
    
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmpSum = nums[i] + nums[j] + nums[k];
                    int tmpDist = Math.abs (target - tmpSum);
                    closestSum = tmpDist < closestSum ? tmpDist : closestSum;
                }
            }
        }
        
        return closestSum;
    }
}
