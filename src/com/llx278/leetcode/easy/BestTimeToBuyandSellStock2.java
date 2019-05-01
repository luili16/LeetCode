package com.llx278.leetcode.easy;

import java.util.*;

public class BestTimeToBuyandSellStock2 {


    public int maxProfit(int[] prices) {
        int maxPrices = 0, temp = 0;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                maxPrices += temp;
            }
        }
        return maxPrices;
    }




    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 5, 3, 6, 9, 8, 9, 100};

        int r = new BestTimeToBuyandSellStock2().maxProfit(a);
        System.out.println(r);

        int m = 702 % 26;

        int v = 702 / 26;

        char mc = (char) (m + 64);
        char mv = (char) (v + 64);
        System.out.println("m : " + m + " v : " + v);

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> integers = map.keySet();
        System.out.println("babad".substring(0, 2));

        int[] nums = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        //new BestTimeToBuyandSellStock2().threeSum(nums);
    }

    private class Indexces {
        int begin;
        int end;
        int sum;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Indexces indexces = (Indexces) o;
            return begin == indexces.begin &&
                    end == indexces.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(begin, end);
        }
    }
}
