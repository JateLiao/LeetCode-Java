package com.lsj.leetcode.problemset.algorithms.finished.medium.on2018_09_04;

import com.lsj.leetcode.problemset.algorithms.common.ListNode;

import java.util.ArrayList;
import java.util.List;

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
        
        // HashMap
        long s = System.currentTimeMillis();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.initListNodesByArray(arr);
        // tmpHead.next = null;
        System.err.print("测试数据：");
        ListNode.showNodes(head);
        int n = 1;
        System.out.println("n = " + n);
        ListNode node = RemoveNthNodeFromEndOfList.removeNthFromEnd(head, n);
        System.err.print("结果：");
        ListNode.showNodes(node);
        System.err.println("耗时：" + String.valueOf(System.currentTimeMillis() - s));
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (null != node) {
            nodes.add(node);
            node = node.next;
        }
        int len = nodes.size();
        if (n == 1) {
            if (len == 1) {
                return null;
            } else {
                nodes.get(len - 2).next = null;
            }
        } else if (n == len) {
            head = nodes.get(1);
        } else {
            nodes.get(len - n - 1).next = nodes.get(len - n + 1);
        }
        
        return head;
    }
}
