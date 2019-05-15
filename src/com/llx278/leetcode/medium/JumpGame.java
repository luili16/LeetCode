package com.llx278.leetcode.medium;

public class JumpGame {

    class Holder {
        boolean found;
    }

    public boolean canJump(int[] nums) {
        Holder h = new Holder();
        jump(nums,0,h);
        System.out.println("h:" + h.found);
        return false;
    }

    public void jump(int[] nums,int index,Holder h) {
        System.out.println(index);

        int num = nums[index];
        for (int i = index + 1; i <= num; i++) {
            int nextIndex = i + nums[i];
            if (nextIndex == nums.length - 1) {
                h.found = true;
                return;
            }
            if (nextIndex < nums.length) {
                jump(nums,nextIndex,h);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        int[] input1 = {1,0,1,0,4};
        int[] input2 = {1};
        int[] input3 = {1,2};
        new JumpGame().canJump(input);
    }
}
