package com.llx278.leetcode.easy;

import com.llx278.leetcode.datastruct.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class SymmetricTree {

    public static class BooleanWrapper {
        boolean isSame;
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        BooleanWrapper w = new BooleanWrapper();
        w.isSame = true;
        travalTrees(left,right,w);
        return w.isSame;
    }

    private void travalTrees(TreeNode p, TreeNode q,BooleanWrapper w) {

        if (p == null && q == null) {
            return;
        }

        if (p == null || q == null) {
            w.isSame = false;
            return;
        }

        if (p.val != q.val) {
            w.isSame = false;
            return;
        }

        travalTrees(p.left, q.right,w);
        if (!w.isSame) {
            return;
        }
        travalTrees(p.right, q.left,w);

    }

}
