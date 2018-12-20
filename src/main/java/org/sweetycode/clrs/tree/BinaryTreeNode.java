package org.sweetycode.clrs.tree;

/**
 * @Auther: sweetycode
 * @Date: 2018/12/20
 * @Description:
 */
public class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    BinaryTreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}
