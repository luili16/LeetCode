package com.llx278.leetcode.easy;

import com.llx278.leetcode.datastruct.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class BalancedBinaryTree  {

    public static class Result {
        public boolean isBalanced;
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        Result result = new Result();
        result.isBalanced = true;
        travelTree(root,result);
        return result.isBalanced;
    }

    private int travelTree(TreeNode node,Result r) {

        if (node.left == null && node.right == null) {
            return 0;
        }
        int l;
        if (node.left == null) {
            l = 0;
        } else {
            l = travelTree(node.left,r) + 1;
        }
        int r1;
        if (node.right == null) {
            r1 = 0;
        } else {
            r1 = travelTree(node.right,r) + 1;
        }

        if (Math.abs(l - r1) > 1) {
            r.isBalanced = false;
        }
        return l > r1?l:r1;
    }

}
