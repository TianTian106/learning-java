package org.sweetycode.leetcode;

import java.util.List;

/**
 * Created by tiantian on 05/08/2018.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}