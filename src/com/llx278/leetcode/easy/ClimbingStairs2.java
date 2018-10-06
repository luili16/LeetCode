package com.llx278.leetcode.easy;


public class ClimbingStairs2 {

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public static void main(String[] args) {


        int ret = new ClimbingStairs2().climbStairs(4);
        System.out.println("ret : " + ret);
    }
}
