package com.lsj.leetcode.problemset.algorithms.medium.on2018_07_22;

import java.util.HashMap;

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
        // HashMap
        long s = System.currentTimeMillis ();
        int[] arr = {1, 2, 3, 4, 5, 0};
        ListNode head = new ListNode (arr[0]);
        ListNode tmpHead = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode (arr[i]);
            tmpHead.next = tmp;
            tmpHead = tmp;
        }
        // tmpHead.next = null;
        System.err.print ("测试数据：");
        showNodes (head);
        int m = 2, n = 3;
        System.out.println("m = " + m + ", n = " + n);
        ListNode values = new ReverseLinkedList2 ().reverseBetween (head, m, n);
        System.err.print("结果：");
        showNodes (head);
        System.err.println ("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public static void showNodes(ListNode head) {
        StringBuilder sb = new StringBuilder ();
        while (head != null) {
            sb.append (head.val).append (" -> ");
            head = head.next;
        }
        sb.append ("NULL");
        System.out.println (sb.toString ());
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
        if (null == head || head.next == null) {
            return null;
        }
        if (m == n) {
            return head;
        }
        ListNode tmpHead = head;
        ListNode tmpNodePriv = tmpHead;
        ListNode nodeM = null; // 第m个节点
        ListNode nodeMPriv = null; // 第m-1个节点
        ListNode nodeMN = null; // 第 m+1 个节点
        ListNode nodeN = null; // 第n个节点
        ListNode nodeNPriv = null; // 第n - 1个节点
        ListNode nodeNN = null; // 第 n+1 个节点
        int index = 1;
        while (null != tmpHead.next) {
            if (m == index) {
                nodeM = tmpHead;
                nodeMN = tmpHead.next;
                nodeMPriv = tmpNodePriv;
            }
            
            if (n == index) {
                nodeN = tmpHead;
                nodeNN = tmpHead.next;
                nodeNPriv = tmpNodePriv;
                
                break; // m <= n
            }
            ++index;
            tmpNodePriv = tmpHead; // 记录上一个节点
            tmpHead = tmpHead.next;
        }
        
        // 进行倒置转换
    
    
        if (m == n) {
        
        } else {
            nodeMPriv.next = nodeN;
            nodeMPriv.next.next = nodeMN;
    
            nodeNPriv.next = nodeM;
            nodeNPriv.next.next = nodeNN;
        }
        
        if (m == 1) {
        
        } else {
        
        }
        
        if (n == 1) {
        
        } else {
        
        }
        
        return head;
    }
    
    /**
     * 链表节点定义.
     */
    static class ListNode {
        int val;
        ListNode next;
        
        public ListNode() {
        }
        
        public ListNode(int x) {
            val = x;
        }
    
        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    
        /**
         * 获取字段值： val.
         *
         * @return 返回字段值： val.
         */
        public int getVal() {
            return val;
        }
    
        /**
         * 设置字段值： val.
         *
         * <p>You can use getVal() to get the value of val</p>
         *
         * @param val val
         */
        public void setVal(int val) {
            this.val = val;
        }
    }
}
