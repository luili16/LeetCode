package com.llx278.leetcode.easy;

public class ClimbingStairs3 {

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int pre, next, count = 0;
        pre = 1;
        next = 2;
        for (int i = 3; i < n; i++) {
            count = pre + next;
            pre = next;
            next = count;
        }

        return count;
    }


    public static void main(String[] args) {


        int ret = new ClimbingStairs3().climbStairs(4);
        System.out.println("ret : " + ret);
    }
}
