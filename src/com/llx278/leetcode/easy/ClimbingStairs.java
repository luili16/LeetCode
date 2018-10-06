package com.llx278.leetcode.easy;

public class ClimbingStairs {
    //Integer count = 0;

    public class Node {
        public Node leftChild;
        public Node rightChild;
        public int value;
    }

    public class CountWrap {
        public int count;
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        Node head = new Node();
        head.value = 0;
        int sum = 0;
        // 构造一颗树，这棵树的根节点的权值是0，所有左孩子权值是1，右孩子的权值是2
        // 并且这颗树所有从根节点到叶子节点的路径的权值和都是n
        CountWrap w = new CountWrap();
        w.count = 0;
        createTree(head, n, sum, w);
        return w.count;
    }

    private void createTree(Node node, int n, int sum, CountWrap count) {
        // 构造左孩子
        createLeftChild(node, n, sum, count);

        // 构造右孩子
        createRightChild(node, n, sum, count);
    }

    private void createLeftChild(Node node, int n, int sum, CountWrap w) {

        Node leftChild = new Node();
        leftChild.value = 1;
        node.leftChild = leftChild;
        sum = sum + 1;
        if (sum == n) {
            w.count++;

        } else if (sum < n) {
            createTree(leftChild, n, sum, w);
        }
    }

    private void createRightChild(Node node, int n, int sum, CountWrap w) {

        Node rightChild = new Node();
        rightChild.value = 2;
        node.rightChild = rightChild;
        sum += 2;
        if (sum == n) {
            w.count++;
        } else if (sum < n) {
            createTree(rightChild, n, sum, w);
        }
    }

    public static void main(String[] args) {
        int n = new ClimbingStairs().climbStairs(44);
        System.out.println(n);
    }
}
