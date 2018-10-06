package com.llx278.leetcode.easy;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        boolean carryFlag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                // 只考虑最后一位加
                int digit = digits[i];
                if (digit == 9) {
                    // 需进位
                    digits[i] = 0;
                    carryFlag = true;
                } else {
                    digits[i] = digit + 1;
                    carryFlag = false;
                }
                continue;
            }

            if (!carryFlag) {
                return digits;
            }

            // 产生了进位标志
            int digit = digits[i];
            if (digit == 9) {
                digits[i] = 0;
                carryFlag = true;
            } else {
                digits[i] = digit + 1;
                // 不需要进位，直接返回
                return digits;
            }
        }

        if (digits[0] == 0) {
            // 最高位进位了
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};

        PlusOne one = new PlusOne();
        int[] ints = one.plusOne(digits);
        System.out.println(Arrays.toString(ints));

    }


}
