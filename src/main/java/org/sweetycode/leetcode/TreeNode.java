package org.sweetycode.leetcode;

/**
 * Created by tiantian on 25/07/2018.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static String inorderTraversal (TreeNode root) {
        String result = "";
        if ( root == null ) return result;

        result = result + inorderTraversal(root.left);
        result = result + root.val;
        result = result + inorderTraversal(root.right);

        return result;

    }
}