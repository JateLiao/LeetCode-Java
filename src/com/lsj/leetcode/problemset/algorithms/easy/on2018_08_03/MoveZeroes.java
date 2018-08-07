package com.lsj.leetcode.problemset.algorithms.easy.on2018_08_03;

import com.lsj.leetcode.util.ArrayUtils;

/**
 * @Desc MoveZeroes
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/8/3 11:35
 * @Author tianzhong
 */
public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 9, 0, 0, 0, 24};
        System.err.println("测试数据：");
        ArrayUtils.showArrays(nums);
        long s = System.currentTimeMillis ();
        new MoveZeroes ().moveZeroes (nums);
        System.err.println("结果：");
        ArrayUtils.showArrays(nums);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public void moveZeroes(int[] nums) {
        if (null == nums) {
            return;
        }
        int len = nums.length;
        int replacedIndex = 0; // 要被替换的index
        int targetIndex = 0; // 目标index
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != 0) {
                continue;
            }
            replacedIndex = i;
            targetIndex = i + 1;
            for (; targetIndex < len; targetIndex++) {
                if (nums[targetIndex] != 0) {
                    break;
                }
            }
            
            // 找到待移动的非零数
            int tmp = nums[replacedIndex];
            nums[replacedIndex] = nums[targetIndex];
            nums[targetIndex] = tmp;
        }
    }
}
