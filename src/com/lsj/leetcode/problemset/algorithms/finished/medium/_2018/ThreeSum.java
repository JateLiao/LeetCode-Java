package com.lsj.leetcode.problemset.algorithms.finished.medium._2018;

import java.util.*;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.finished.medium.on2018_05_24
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/5/2423:45
 */
public class ThreeSum {
    /**
     * 通过
     *
     *
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
        // -1, 0, 1, 2, -1, -4 nums={ -1, 0, 1, 2, -1, -4};
        int[] nums = { 0,0,0,0};
        long s = System.currentTimeMillis ();
        List<List<Integer>> values = new ThreeSum ().threeSum (nums);
        System.err.println("数组Size：" + nums.length);
        
        System.out.println(values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<> ();
        if (null == nums || nums.length < 3) {
            return results;
        }
        Arrays.sort (nums); // 升序排序
        int len = nums.length;
        for (int i = 0; i < len - 2 && nums[i] <= 0; i++) { // 二分夹逼
            if (i >= 1 && nums[i] == nums[i - 1]) { // 相等的连续两个数
                continue;
            }
            int dif = -nums[i]; // 相反数
            int start = i + 1;
            int end = len - 1;
            
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == dif) { // 满足和为0
                    List<Integer> tmpVals = new ArrayList<> ();
                    tmpVals.add (nums[i]);
                    tmpVals.add (nums[start]);
                    tmpVals.add (nums[end]);
                    results.add (tmpVals);
                    while (start < end && nums[start] == nums[start + 1]) {
                        ++start;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        --end;
                    }
                    ++start;
                    --end;
                } else if (sum < dif) {
                    ++start;
                } else {
                    --end;
                }
            }
        }

        
        /** 以下为暴力循环，结果超时，尴尬 */
//        if (len == 3 && nums[0] + nums[1] + nums[2] == 0) {
//            List<Integer> tmpVals = new ArrayList<> ();
//            tmpVals.add (nums[0]);
//            tmpVals.add (nums[1]);
//            tmpVals.add (nums[2]);
//            results.add (tmpVals);
//            return results;
//        }
//        List<Set<Integer>> existVlues = new ArrayList<> ();
//        for (int i = 0; i <= len - 3; i++) {
//            for (int j = i + 1; j <= nums.length - 2; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        Set<Integer> existVal = new HashSet<> (3);
//                        List<Integer> tmpVals = new ArrayList<> ();
//                        tmpVals.add (nums[i]);
//                        tmpVals.add (nums[j]);
//                        tmpVals.add (nums[k]);
//                        if (checkExist(existVlues, nums[i], nums[j], nums[k])) {
//                            continue;
//                        }
//
//                        existVal.add (nums[i]);
//                        existVal.add (nums[j]);
//                        existVal.add (nums[k]);
//                        existVlues.add (existVal);
//                        results.add (tmpVals);
//                    }
//                }
//            }
//        }
    
        return results;
    }
    
    /**
     * @param existVlues existVlues.
     */
    private boolean checkExist(List<Set<Integer>> existVlues, int i, int j, int k) {
        if (null == existVlues || existVlues.isEmpty ()) {
            return false;
        }
        for (Set<Integer> existSet : existVlues) {
            if (i == j && i == 0) {
                if (existSet.contains (i) && existSet.size () == 1) {
                    return true;
                } else {
                    continue;
                }
            }
            if (existSet.contains (i) && existSet.contains (j) && existSet.contains (k)) {
                return true;
            }
        }
        return false;
    }
}
