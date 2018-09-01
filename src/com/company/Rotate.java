package com.company;

public class Rotate {
    public void rotate(int[] nums, int key) {

        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        // 至少有两个元素
        for (int i = 1; i <= key; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; --j) {
                int index = j;
                nums[++index] = nums[j];
            }
            nums[0] = temp;
        }
    }
}
