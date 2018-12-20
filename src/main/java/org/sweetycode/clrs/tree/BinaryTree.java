package org.sweetycode.clrs.tree;

/**
 * @Auther: sweetycode
 * @Date: 2018/12/20
 * @Description:
 */
public class BinaryTree {
    BinaryTreeNode root;

    /* Function to traverse binary tree without recursion and
       without stack */
    void MorrisTraversal(BinaryTreeNode root)
    {
        BinaryTreeNode current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    /* Revert the changes made in if part to restore the
                    original tree i.e., fix the right child of predecssor*/
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
    }

    public static void main(String args[])
    {
        /* Constructed binary tree is
               4
             /   \
            2      5
          /  \
        1     3
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(5);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        tree.MorrisTraversal(tree.root);
    }
}
