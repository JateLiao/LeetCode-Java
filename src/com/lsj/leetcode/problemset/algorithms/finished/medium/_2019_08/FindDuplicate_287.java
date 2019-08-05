package com.lsj.leetcode.problemset.algorithms.finished.medium._2019_08;

/**
 * @author liaoshijie
 * @description: ${TODO}
 * @Createtime 2019/8/5 20:02
 */
public class FindDuplicate_287 {
    /**
     * NO: 287
     * URL: https://leetcode-cn.com/problems/find-the-duplicate-number/
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     *
     * 示例 1:
     * 输入: [1,3,4,2,2]
     * 输出: 2
     *
     * 示例 2:
     * 输入: [3,1,3,4,2]
     * 输出: 3
     *
     * 说明：
     *     不能更改原数组（假设数组是只读的）。
     *     只能使用额外的 O(1) 的空间。
     *     时间复杂度小于 O(n^2) 。
     *     数组中只有一个重复的数字，但它可能不止重复出现一次。
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2};
        int value = findDuplicate(arr);
        System.out.println(value);
    }
    
    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        if (length > 1) {
            // 找到快慢指针相遇的地方
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
        
            // 用一个新指针从头开始，直到和慢指针相遇
            fast = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        
        
        /** 哈希表 */
        //HashMap<Integer, Integer> map = new HashMap<>();
        //for (int i = 0; i < nums.length; i++) {
        //    if (map.containsKey(nums[i])) {
        //        return nums[i];
        //    } else {
        //        map.put(nums[i], 0);
        //    }
        //}
        //
        
        /** 循环嵌套 */
        ///////////////////////////////////////////
        //for (int i = 0; i < nums.length - 1; i++) {
        //    for (int j = i + 1; j < nums.length; j++) {
        //        if (nums[i] == nums[j]) {
        //            return nums[i];
        //        }
        //    }
        //}
        
        return -1;
    }
}
