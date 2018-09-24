package com.llx278.leetcode.easy;

public class LengthOfLastWrod {

    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        }

        return words[words.length - 1].length();
    }


    public static void main(String[] args) {
        LengthOfLastWrod l = new LengthOfLastWrod();
        int i = l.lengthOfLastWord(" a");
        System.out.println("i : " + i);
    }
}
