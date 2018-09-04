package com.lsj.leetcode.problemset.algorithms.notfinished.medium.on2018_09_04;

/**
 * @Desc RemoveNthNodeFromEndOfList
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/9/4 17:37
 * @Author tianzhong
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 19. 删除链表的倒数第N个节点
     * url：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        
        String str = "";
        System.err.println("测试数据：" + str);
        int n = 0;
        long s = System.currentTimeMillis();
        ListNode node = RemoveNthNodeFromEndOfList.removeNthFromEnd(null, n);
        System.err.println("结果：" + node);
        System.err.println("耗时：" + String.valueOf(System.currentTimeMillis() - s));
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }
    
    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
}
