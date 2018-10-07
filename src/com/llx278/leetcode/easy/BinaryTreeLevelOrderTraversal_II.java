package com.llx278.leetcode.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversal_II {

    public static class DeepCount{
        int deepth = 0;
        int maxDeep = 0;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        DeepCount d = new DeepCount();
        d.deepth = 1;
        d.maxDeep = 0;

        travelTree(root,d,list);
        Collections.reverse(list);
        return list;

    }

    private void travelTree(TreeNode node,DeepCount d,List<List<Integer>> lists) {

        if (node == null) {
            d.deepth--;
            return;
        }

        if (lists.size() < d.deepth) {
            List<Integer> list = new LinkedList<>();
            list.add(node.val);
            lists.add(list);
        } else {
            List<Integer> list = lists.get(d.deepth - 1);
            list.add(node.val);
        }

        if (node.left == null && node.right == null) {
            d.deepth--;
            return;
        }
        d.deepth++;
        travelTree(node.left, d,lists);
        d.deepth++;
        travelTree(node.right, d,lists);
        d.deepth--;
    }

}
