package com.company;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    private String longestCommonPrefix(String[]strs) {

        int[] indexes = new int[strs.length];
        StringBuilder sb = new StringBuilder();
        int smallest = 0;
        for (int i = 0;i<indexes.length;i++) {
            int len = strs[i].length();
            if (smallest == 0 && i == 0) {
                smallest = len;
            } else {
                if (len < smallest) {
                    smallest = len;
                }
            }
            if (i == 0) {
                indexes[i] = 0;
            } else {
                int lastIndex = i - 1;
                if (lastIndex == 0) {
                    indexes[i] = strs[lastIndex].length();
                } else {
                    indexes[i] = strs[lastIndex].length() + indexes[lastIndex];
                }

            }
            sb.append(strs[i]);
        }

        String contactStr = sb.toString();
        StringBuilder cp = new StringBuilder();
        for (int i = 0; i < smallest; i++) {
            char c = contactStr.charAt(i);
            for (int j = 1; j < indexes.length;j++) {
                char pre = contactStr.charAt(indexes[j]++);
                if (pre != c) {
                    return cp.toString();
                }
            }
            cp.append(c);
        }
        return cp.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String ret = lcp.longestCommonPrefix(new String[]{"aac","acab","aa","abba","aa"});
        System.out.print(ret);

    }
}
