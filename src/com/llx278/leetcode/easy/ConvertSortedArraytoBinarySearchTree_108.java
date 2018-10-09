package com.llx278.leetcode.easy;

import com.llx278.leetcode.datastruct.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedArraytoBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {


        if (nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        if (nums.length == 2) {
            TreeNode root = new TreeNode(nums[0]);
            TreeNode node = new TreeNode(nums[1]);
            insertTo(root, node);
            return root;
        }

        int middleIndex = nums.length / 2;
        int leftBegin = 0;
        int leftEnd = middleIndex - 1;
        int rightBegin = middleIndex + 1;
        int rightEnd = nums.length - 1;
        TreeNode root = new TreeNode(nums[middleIndex]);
        System.out.println("middle : " + nums[middleIndex]);
        generate(nums, root, leftBegin, leftEnd, rightBegin, rightEnd);
        return root;

    }

    private void insertTo(TreeNode root, TreeNode node) {

        TreeNode temp = root;
        while (true) {
            if (temp.val >= node.val) {

                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = node;
                    break;
                }

            } else {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = node;
                    break;
                }
            }
        }
    }

    private void generate(int[] nums, TreeNode node, int leftBegin, int leftEnd, int rightBegin, int rightEnd) {
        if (leftBegin == leftEnd) {
            TreeNode left = new TreeNode(nums[leftBegin]);
            System.out.println("middle0 : " + nums[leftBegin]);
            insertTo(node, left);
        } else {


            if (leftEnd - leftBegin + 1 == 2) {
                generate(nums, node, leftBegin, leftBegin, leftEnd, leftEnd);
            } else {
                int leftMiddleIndex = (leftEnd - leftBegin + 1) / 2 + leftBegin;
                System.out.println("leftMiddle : " + nums[leftMiddleIndex]);
                TreeNode left = new TreeNode(nums[leftMiddleIndex]);
                insertTo(node, left);
                int newLeftBegin1 = leftBegin;
                int newLeftEnd1 = leftMiddleIndex - 1;
                int newRightBegin1 = leftMiddleIndex + 1;
                int newRightEnd1 = leftEnd;
                generate(nums, node, newLeftBegin1, newLeftEnd1, newRightBegin1, newRightEnd1);
            }

        }

        if (rightBegin == rightEnd) {
            TreeNode right = new TreeNode(nums[rightBegin]);
            System.out.println("middle1 : " + nums[rightBegin]);
            insertTo(node, right);
        } else {

            if (rightEnd - rightBegin + 1 == 2) {
                generate(nums, node, rightBegin, rightBegin, rightEnd, rightEnd);
            } else {
                int rightMiddleIndex = (rightEnd - rightBegin + 1) / 2 + rightBegin;
                System.out.println("rightMiddle : " + nums[rightMiddleIndex]);
                TreeNode right = new TreeNode(nums[rightMiddleIndex]);
                insertTo(node, right);
                int newLeftBegin2 = rightBegin;
                int newLeftEnd2 = rightMiddleIndex - 1;
                int newRightBegin2 = rightMiddleIndex + 1;
                int newRightEnd2 = rightEnd;
                generate(nums, node, newLeftBegin2, newLeftEnd2, newRightBegin2, newRightEnd2);
            }
        }
    }

    public static void main(String[] args) {
        new ConvertSortedArraytoBinarySearchTree_108().sortedArrayToBST(new int[]{1, 3});
    }

}
