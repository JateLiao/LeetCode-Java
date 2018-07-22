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
        long s = System.currentTimeMillis ();
        int[] arr = {1, 5, 8, 9, 3, 0};
        int m = 0, n = 0;
        
        
        System.err.println ("测试数据：" + arr.toString ());
        ListNode head = new ListNode(arr[0]);
        ListNode tmpHead = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode (arr[i]);
            tmpHead = new ListNode (arr[i]);
            tmpHead.next = tmp;
            tmpHead = tmp;
        }
        tmpHead.next = null;
        
        ListNode values = new ReverseLinkedList2 ().reverseBetween (head, m, n);
        System.err.println ("耗时：" + String.valueOf (System.currentTimeMillis () - s));
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
    static class ListNode {
        int val;
        ListNode next;
        
        public ListNode() { }
    
        public ListNode(int x) {
            val = x;
        }
    }
}
