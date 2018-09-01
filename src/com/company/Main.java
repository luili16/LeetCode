package com.company;

import java.util.*;
import java.util.List;
import static java.lang.System.out;

public class Main {


    static class Solution {

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

        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{0, 0};
        }

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

        int reverse(int x) {

            List<Integer> list = new ArrayList<>();
            int maxScale = 1000000000;
            //             2147483647
            //            -2147483648
            int maxValue = Integer.MAX_VALUE;
            int minValue = Integer.MIN_VALUE;
            int divNum;
            int preDivNum = 0;
            int scale = 10;

            while (preDivNum != x) {
                divNum = ((x - preDivNum) % scale);
                list.add(divNum / (scale / 10));
                // 题目假设了整形的数值范围 : [−2^31,  2^31 − 1]
                preDivNum += divNum;

                if (scale != maxScale) {
                    scale *= 10;
                } else {
                    // 到了最高位,下次循环scale会溢出，所以直接将最高位的值入栈
                    int highestNum = x / scale;
                    if (highestNum != 0) {
                        list.add(highestNum);
                    }
                    break;
                }
            }

            out.println(list);
            int result = 0;
            // 恢复正常的缩放比例
            scale = 1;

            for (int i = list.size() - 1; i >= 0; i--) {
                int num = list.get(i);
                int value = 0;
                if (scale != maxScale) {
                    value = (num * scale);
                } else {
                    // 判断是否会溢出
                    if (num > 2 || num < -2) {
                        // 这种情况肯定会溢出
                        return 0;
                    } else {
                        value = num * scale;
                    }
                }

                // 判断相加是不是会溢出
                if (result > 0 && (maxValue - value) < result) {
                    return 0;
                } else if (result < 0 && (minValue - value) > result) {
                    return 0;
                }

                result += value;
                scale *= 10;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        // write your code here

        Solution solution = new Solution();
        int result = solution.reverse(463847412);
        //int result = solution.reverse(123);
        out.println(result);
    }
}
