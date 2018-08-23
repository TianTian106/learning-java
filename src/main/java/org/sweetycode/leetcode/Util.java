package org.sweetycode.leetcode;

import java.util.Arrays;

/**
 * Created by tiantian on 21/07/2018.
 */
public class Util {
    public static void printArray (int[][] a) {
        for(int i = 0; i < a.length; i ++) {
            System.out.println(Arrays.toString(a[i]));
        }

    }

    public static void printListNode(ListNode listNode) {
        if(listNode == null) return;
        String str = String.valueOf(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            str = str + "->" + listNode.val;
        }
        System.out.println(str);
    }
}