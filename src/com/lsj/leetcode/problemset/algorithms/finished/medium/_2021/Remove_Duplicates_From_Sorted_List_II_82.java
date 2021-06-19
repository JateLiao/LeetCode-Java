package com.lsj.leetcode.problemset.algorithms.finished.medium._2021;

import com.lsj.leetcode.problemset.algorithms.common.ListNode;

/**
 * @author liaoshijie@jojoreading.com
 * @since 2021/6/15 下午7:36
 */
public class Remove_Duplicates_From_Sorted_List_II_82 {
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     * 返回同样按升序排列的结果链表。
     *
     * 示例 1：
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *
     * 示例 2：
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *
     * 提示：
     *     链表中节点数目在范围 [0, 300] 内
     *     -100 <= Node.val <= 100
     *     题目数据保证链表已经按升序排列
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * main method.
     **/
    public static void main(String[] args) {
        ListNode head = ListNode.initListNodesByArray(0, 0, 1, 2, 2, 3, 3, 4);
        ListNode.showNodes(head);
        ListNode newHead = deleteDuplicates3(head);
        System.out.println("去重后：");
        ListNode.showNodes(newHead);
    }

    /**
     * 理解错了题意，保留了重复数字，也许其他题可以用到就不删了
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            ListNode next = getNextNode(tmp);
            if (next == null) {
                tmp.next = null;
                break;
            }
            tmp.next = next;
            tmp = tmp.next;
        }
        return head;
    }

    private static ListNode getNextNode(ListNode tmp) {
        int val = tmp.val;
        ListNode next = tmp.next;
        while (next != null && next.val == val) {
            next = next.next;
        }
        return next;
    }

    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode newHead = getNextNotRepeatNode(head);
        if (newHead == null) {
            return null;
        }
        ListNode tmp = newHead;
        ListNode next;

        while ((next = getNextNotRepeatNode(tmp.next)) != null) {
            tmp.next = next;
            tmp = tmp.next;
        }
        tmp.next = null;
        return newHead;
    }

    private static ListNode getNextNotRepeatNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            return head;
        }
        int repeatVal = head.val;
        ListNode tmp = head.next;
        while (tmp != null) {
            if (tmp.val != repeatVal) {
                if (tmp.next == null) {
                    return tmp;
                }
                if (tmp.val != tmp.next.val) {
                    return tmp;
                }
                repeatVal = tmp.val;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
