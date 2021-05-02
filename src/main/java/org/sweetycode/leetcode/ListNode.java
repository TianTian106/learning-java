package org.sweetycode.leetcode;

/**
 * Created by tiantian on 04/07/2018.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode(int[] a) {
        if(a == null) return;
        this.val = a[0];
        ListNode flag = this;
        for (int i = 1 ; i < a.length; i ++) {
            flag.next = new ListNode(a[i]);
            flag = flag.next;
        }
    }
}


