package com.lsj.leetcode.problems.algorithms.medium.on2018_05_24;

import java.util.*;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problems.algorithms.medium.on2018_05_24
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/5/2423:45
 */
public class ThreeSum {
    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */
    public static void main(String[] args) {
        // -1, 0, 1, 2, -1, -4, 4, 0, 1, -2, 3, -1, -3
        // -1, 0, 1, 2, -1, -4
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        List<List<Integer>> values = new ThreeSum ().threeSum (nums);
        
        System.out.println(values);
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<> ();
        if (null == nums || nums.length < 3) {
            return results;
        }
        
        int len = nums.length;
        if (len == 3 && nums[0] + nums[1] + nums[2] == 0) {
            List<Integer> tmpVals = new ArrayList<> ();
            tmpVals.add (nums[0]);
            tmpVals.add (nums[1]);
            tmpVals.add (nums[2]);
            results.add (tmpVals);
            return results;
        }
        List<Set<Integer>> existVlues = new ArrayList<> ();
        for (int i = 0; i <= len - 3; i++) {
            for (int j = i + 1; j <= nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Set<Integer> existVal = new HashSet<> (3);
                        List<Integer> tmpVals = new ArrayList<> ();
                        tmpVals.add (nums[i]);
                        tmpVals.add (nums[j]);
                        tmpVals.add (nums[k]);
                        if (checkExist(existVlues, nums[i], nums[j], nums[k])) {
                            continue;
                        }
    
                        existVal.add (nums[i]);
                        existVal.add (nums[j]);
                        existVal.add (nums[k]);
                        existVlues.add (existVal);
                        results.add (tmpVals);
                    }
                }
            }
        }
    
        return results;
    }
    
    /**
     * @param existVlues existVlues.
     */
    private boolean checkExist(List<Set<Integer>> existVlues, int i, int j, int k) {
        if (null == existVlues || existVlues.isEmpty ()) {
            return false;
        }
        boolean isExist = false;
        for (Set<Integer> existSet : existVlues) {
            if (i == j && i == 0) {
                if (existSet.contains (i) && existSet.size () == 1) {
                    return true;
                } else {
                    return false;
                }
                
            }
            if (existSet.contains (i) && existSet.contains (j) && existSet.contains (k)) {
                return true;
            }
        }
        return isExist;
    }
}
