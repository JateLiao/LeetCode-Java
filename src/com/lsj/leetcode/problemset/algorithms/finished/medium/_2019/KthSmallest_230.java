package com.lsj.leetcode.problemset.algorithms.finished.medium._2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liaoshijie
 * @description: ${TODO}
 * @Createtime 2019/8/5 19:27
 */
public class KthSmallest_230 {
    /**
     * 题号：230
     * URL：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     *
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     *
     * 示例 1:
     *
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 1
     *
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 3
     *
     * 进阶：
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        int smallest = kthSmallest(root, 1);
        System.out.println(smallest);
    }
    
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
    
        appendNodeValue(root, list);
    
        Collections.sort(list);
    
        return list.get(k - 1);
    }
    
    private static void appendNodeValue(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }
        list.add(node.val);
        if (null != node.left) {
            appendNodeValue(node.left, list);
        }
        if (null != node.right) {
            appendNodeValue(node.right, list);
        }
    }
    
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        public TreeNode(int x) {
            val = x;
        }
    }
    
}
