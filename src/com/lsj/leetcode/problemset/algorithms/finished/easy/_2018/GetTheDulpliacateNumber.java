package com.lsj.leetcode.problemset.algorithms.finished.easy._2018;

import com.lsj.leetcode.util.ArrayUtils;

import java.util.Arrays;

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
     * 找出数组中重复的数字。
     *
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     *
     *
     * 限制：
     *
     * 2 <= n <= 100000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        int[] nums = {0, 5, 1, 2, 6, 9, 8, 4, 5, 3, 2, 4, 1};
        System.err.print("测试数据：");
        ArrayUtils.showArrays(nums);
        long s = System.currentTimeMillis();
        int values = findRepeatNumber(nums);
        System.err.println("结果：" + values);
        System.err.println("耗时：" + String.valueOf(System.currentTimeMillis() - s));
    }

    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
