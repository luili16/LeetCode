package com.llx278.leetcode.easy;

import com.llx278.leetcode.datastruct.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        int value = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            if (node != null) {
                value += node.val;
                if (value == sum) {
                    return true;
                } else  {

                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
            }
        }
        return false;
    }
}
