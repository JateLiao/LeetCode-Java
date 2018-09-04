package com.lsj.leetcode.problemset.algorithms.common;

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
}
