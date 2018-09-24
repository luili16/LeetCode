package com.llx278.leetcode.easy;

public class MaximumSubArray {



    public int maxSubArray(int[] nums) {
        Result r = maxSubArrayRecursive(nums, 0, nums.length - 1);
        return r.max;
    }


    private static class Result {
        final int beginIndex;
        final int endIndex;
        final int max;

        public Result(int beingIndex, int endIndex, int max) {
            this.beginIndex = beingIndex;
            this.endIndex = endIndex;
            this.max = max;
        }
    }

    public Result maxSubArrayRecursive(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            return new Result(beginIndex, endIndex, nums[beginIndex]);
        }

        int length = endIndex - beginIndex + 1;
        int middleIndex = beginIndex + length / 2 - 1;

        Result maxCrossingMiddle = findMaximumCrossingMiddle(nums, beginIndex, middleIndex, endIndex);
        Result preResult = maxSubArrayRecursive(nums, beginIndex, middleIndex);
        Result nextResult = maxSubArrayRecursive(nums, middleIndex +1, endIndex);

        Result[] maxs = new Result[]{maxCrossingMiddle, preResult, nextResult};

        Result relResult = maxs[0];
        for (Result max1 : maxs) {
            if (max1.max > relResult.max) {
                relResult = max1;
            }
        }

        return relResult;

    }

    private Result findMaximumCrossingMiddle(int[] nums, int low, int middle, int high) {

        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = low;
        for (int i = middle; i >= low; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = high;
        for (int i = middle + 1; i <= high; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new Result(maxLeft, maxRight, rightSum + leftSum);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubArray m = new MaximumSubArray();
        int ret = m.maxSubArray(nums);
        System.out.println("ret : " + ret);

    }
}
