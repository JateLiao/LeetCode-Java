package com.lsj.leetcode.problemset.algorithms.finished.medium._2021;

import com.lsj.leetcode.problemset.algorithms.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoshijie@jojoreading.com
 * @since 2021/6/14 下午9:55
 */
public class RotateList_61 {
    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * 示例 1：
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     *
     * 示例 2：
     *
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     *
     * 提示：
     *
     *     链表中节点的数目在范围 [0, 500] 内
     *     -100 <= Node.val <= 100
     *     0 <= k <= 2 * 109
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * main method.
     **/
    public static void main(String[] args) {
        ListNode head = ListNode.initListNodesByArray(1, 2, 3, 4, 5);
        ListNode.showNodes(head);
        int k = 2;
        ListNode newHead = rotateRight(head, k);
        System.out.println("翻转后：");
        ListNode.showNodes(newHead);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 计算链表长度，提取原始值
        ListNode tmp = head;
        List<Integer> values = new ArrayList<>();
        values.add(tmp.val);
        while (tmp.next != null) {
            tmp = tmp.next;
            values.add(tmp.val);
        }
        int len = values.size();
        int[] new_val_arr = new int[len];
        int mod = k % len;
        // 每个元素转移至新的位置
        for (int i = 0; i < len; i++) {
            // 计算新的坐标
            int newIndex = i + mod;
            if (newIndex >= len) {
                newIndex = newIndex - len;
            }
            new_val_arr[newIndex] = values.get(i);
        }
        // 构造新链表
        ListNode newHead = new ListNode(new_val_arr[0]);
        ListNode newTmp = newHead;
        for (int i = 1; i < len; i++) {
            ListNode node = new ListNode(new_val_arr[i]);
            newTmp.next = node;
            newTmp = newTmp.next;
        }
        return newHead;
    }
}
