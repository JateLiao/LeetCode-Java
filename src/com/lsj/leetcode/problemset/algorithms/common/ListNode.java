package com.lsj.leetcode.problemset.algorithms.common;

import java.util.List;

/**
 * @Desc ListNode
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/9/4 17:48
 * @Author tianzhong
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode(int x) {
        val = x;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
    
    
    /**
     * showNodes.
     * @param head head.
     */
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
     * 根据数组生成一个链表，并返回头结点.
     * @param arr arr.
     * @return head.
     */
    public static ListNode initListNodesByArray(int...arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        ListNode node = new ListNode(arr[0]);
        ListNode head = node;
        for (int i = 1, len = arr.length; i < len; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        node.next = null;
        return head;
    }
}
