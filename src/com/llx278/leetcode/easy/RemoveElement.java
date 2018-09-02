package com.llx278.leetcode.easy;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int lastIndex = nums.length - 1;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {

                while (nums[lastIndex] == val) {
                    if (lastIndex == i) {
                        index = i;
                        return index;
                    }
                    lastIndex--;
                }

                int temp = nums[lastIndex];
                nums[lastIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return ++index;
    }

}
