package com.llx278.leetcode.easy;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m;

        if (len == 0) {
            System.arraycopy(nums2,0,nums1,0,n);
            return;
        }

        for (int i = 0; i < n; i++) {
            int num2 = nums2[i];
            for (int j = 0; j < len;j++) {
                int num1 = nums1[j];
                if (num2 <= num1) {
                    // 从j这个位置开始，往后移一个位置
                    for (int k = nums1.length - 2; k >=j ;k--) {
                        nums1[k + 1]=nums1[k];
                    }
                    nums1[j] = num2;
                    len++;
                    break;
                }
                if (j == len - 1) {
                    // 直接插到下一个位置
                    nums1[len] = num2;
                    len++;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {0};
        int[] nums2 = new int[] {1};

        new Merge().merge(nums1,0,nums2,1);
        int a = (int) Math.ceil(2.5);
        System.out.println(a);
        System.out.println(Arrays.toString(nums1));
    }
}
