package com.llx278.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BestTimeToBuyandSellStock {

    public static class Holder {
        private int price;
        private int begin;
        private int end;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Holder holder = (Holder) o;
            return price == holder.price &&
                    begin == holder.begin &&
                    end == holder.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, begin, end);
        }

        @Override
        public String toString() {
            return "Holder{" +
                    "price=" + price +
                    ", begin=" + begin +
                    ", end=" + end +
                    '}';
        }
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        if (prices.length == 1) {
            return 0;
        }

        return findMaxPrices(prices, 0, prices.length - 1);
    }

    public int findMaxPrices(int[] prices, int begin, int end) {
        if (begin == end) {
            return 0;
        }
        int max;
        int len = end - begin + 1;
        if (len == 2) {
            int price = prices[end] - prices[begin];
            if (price < 0) {
                return 0;
            } else {
                return price;
            }
        }
        // 左右两边找
        int middle = begin + len / 2;
        int leftBegin = begin;
        int leftEnd = middle - 1;
        int leftMax = findMaxPrices(prices, leftBegin, leftEnd);
        int rightBegin = middle;
        int rightEnd = end;
        int rightMax = findMaxPrices(prices, rightBegin, rightEnd);

        // 从中间开始找
        // 找到右边最大，左边最小的
        int leftMinInMiddle = prices[begin];
        for (int i = begin; i <= middle; i++) {
            if (prices[i] < leftMinInMiddle) {
                leftMinInMiddle = prices[i];
            }
        }
        int rightMaxInMiddle = prices[middle];
        for (int i = middle; i <= end; i++) {
            if (prices[i] > rightMaxInMiddle) {
                rightMaxInMiddle = prices[i];
            }
        }

        int[] all = new int[]{leftMax, rightMax, rightMaxInMiddle - leftMinInMiddle};
        max = all[0];
        for (int a : all) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
