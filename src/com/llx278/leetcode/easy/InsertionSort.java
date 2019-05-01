package com.llx278.leetcode.easy;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] nums) {
        for (int j = 1; j < nums.length; j++) {
            int key = nums[j];
            int i = j - 1;
            while (i >= 0 && nums[i] < key) {
                nums[i+1]  = nums[i];
                i--;
            }
            nums[i + 1] = key;
        }
    }

    public void callByValue(Integer i) {
        Integer integer = Integer.valueOf(5);

    }

    public static void main(String[] args) {
        int[] nums = {5,2,4,6,1,3};
        InsertionSort.insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
