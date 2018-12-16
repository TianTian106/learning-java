package org.sweetycode.leetcode;

/**
 * Created by tiantian on 2018/12/16.
 */
// Definition for a QuadTree node.
class QuadTreeNode {
    public boolean val;
    public boolean isLeaf;
    public QuadTreeNode topLeft;
    public QuadTreeNode topRight;
    public QuadTreeNode bottomLeft;
    public QuadTreeNode bottomRight;

    public QuadTreeNode() {}

    public QuadTreeNode(boolean _val,boolean _isLeaf,QuadTreeNode _topLeft,QuadTreeNode _topRight,QuadTreeNode _bottomLeft,QuadTreeNode _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}