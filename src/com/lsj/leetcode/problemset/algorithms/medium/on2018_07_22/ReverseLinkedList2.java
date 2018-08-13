package com.lsj.leetcode.problemset.algorithms.medium.on2018_07_22;

import java.util.ArrayList;
import java.util.List;

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
        int[] arr = {5};
        ListNode head = new ListNode (arr[0]);
        ListNode tmpHead = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode (arr[i]);
            tmpHead.next = tmp;
            tmpHead = tmp;
        }
        // tmpHead.next = null;
        System.err.print("测试数据：");
        showNodes(head);
        int m = 1, n = 1;
        System.out.println("m = " + m + ", n = " + n);
        ListNode values = new ReverseLinkedList2().reverseBetween(head, m, n);
        System.err.print("结果：");
        showNodes(values);
        System.err.println("耗时：" + String.valueOf(System.currentTimeMillis() - s));
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
        if (null == head) {
            return null;
        }
        if (m == n) {
            return head;
        }
        ListNode tmpHead = head;
        ListNode tmpNodePriv = tmpHead;
        ListNode nodeMPriv = null; // 第m-1个节点
        ListNode nodeNN = null; // 第 n+1 个节点
        int index = 1;
    
        List<ListNode> reverseNodes = new ArrayList<>(n - m + 1);
        while (null != tmpHead && index <= n) {
            if (m == index) {
                nodeMPriv = tmpNodePriv;
            }
            
            if (n == index) {
                nodeNN = tmpHead.next;
            }
            tmpNodePriv = tmpHead; // 记录上一个节点
            if (index >= m && index <= n) {
                reverseNodes.add(tmpHead);
            }
            tmpHead = tmpHead.next;
            ++index;
        }
        
        // 进行倒置转换
        ListNode resultNode = head;
        int len = reverseNodes.size();
        if (len >= 1) {
            int start = 0;
            if (m != 1) { // // 从头结点开始反转
                tmpHead = nodeMPriv;
                start = len - 1;
            } else {
                tmpHead = reverseNodes.get(len - 1);
                resultNode = tmpHead;
                start = len - 2;
            }
            for (int i = start; i >= 1; i--) {
                tmpHead.next = reverseNodes.get(i);
                reverseNodes.get(i).next = reverseNodes.get(i - 1);
                tmpHead = tmpHead.next;
            }
            tmpHead.next = reverseNodes.get(0);
            if (n == index) { // 到尾节点结束
                tmpHead.next.next = null;
            } else {
                tmpHead.next.next = nodeNN;
            }
        }
        
        return resultNode;
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
    }
}
