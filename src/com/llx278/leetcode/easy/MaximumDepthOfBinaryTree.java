package com.llx278.leetcode.easy;

import java.util.Collections;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        DeepCount d = new DeepCount();
        d.deepth = 1;
        d.maxDeep = 0;
        travelTree(root,d);
        return d.maxDeep;
    }

    public static class DeepCount{
        int deepth = 0;
        int maxDeep = 0;
    }

    private void travelTree(TreeNode node,DeepCount d) {
        if (node == null) {
            d.deepth--;
            return;
        }

        if (node.left == null && node.right == null) {
            if (d.deepth > d.maxDeep) {
                d.maxDeep = d.deepth;
            }
            d.deepth--;
            return;
        }
        d.deepth++;
        travelTree(node.left,d);
        d.deepth++;
        travelTree(node.right,d);
        d.deepth--;
    }

}
