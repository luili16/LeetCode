package com.llx278.leetcode.easy;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int moreLonger;
        int offset;
        if (a.length() > b.length()) {
            moreLonger = a.length();
            offset = a.length() - b.length();
        } else {
            moreLonger = b.length();
            offset = b.length() - a.length();
        }

        char[] res = new char[moreLonger];
        boolean carryFlag = false;
        for (int i = moreLonger - 1; i >= 0; i--) {
            char aBit;
            char bBit;
            if (a.length() > b.length()) {
                aBit = a.charAt(i);

                if (i - offset < 0) {
                    bBit = '0';
                } else {
                    bBit = b.charAt(i - offset);
                }

            } else {

                if (i - offset < 0) {
                    aBit = '0';
                } else {
                    aBit = a.charAt(i - offset);
                }

                bBit = b.charAt(i);
            }


            // 只有 1 和 1 会产生进位
            if (aBit == '1' && bBit == '1') {

                if (carryFlag) {
                    res[i] = '1';
                } else {
                    res[i] = '0';
                }
                carryFlag = true;
            } else if (aBit == '0' && bBit == '0') {

                if (carryFlag) {
                    res[i] = '1';
                } else {
                    res[i] = '0';
                }
                carryFlag = false;
            } else if (aBit == '1' && bBit == '0'
                    || aBit == '0' && bBit == '1') {

                if (carryFlag) {
                    res[i] = '0';
                    carryFlag = true;
                } else {
                    res[i] = '1';
                    carryFlag = false;
                }
            }
        }

        if (carryFlag) {
            char[] newRes = new char[res.length + 1];
            System.arraycopy(res, 0, newRes, 1, res.length);
            newRes[0] = '1';
            return String.valueOf(newRes);
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        String c = new AddBinary().addBinary(a, b);
        System.out.println(c);
    }

}
