package com.lsj.leetcode.problemset.algorithms.medium.on2018_07_22;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.medium.on2018_07_22
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/7/220:02
 */
public class ReverseLinkedList2 {
    /**
     * 题目名：反转链表 II
     * URL：https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
     *
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        String[] str = {"abcd", "dcba", "lls", "s", "sssll"};
        System.err.println("测试数据：" + str.length);
        ListNode node = null;
        int m = 0, n = 0;
        long s = System.currentTimeMillis ();
        ListNode values = new ReverseLinkedList2 ().reverseBetween(null, m, n);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
    
        return null;
    }
    
    /**
     * 链表节点定义.
     */
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
