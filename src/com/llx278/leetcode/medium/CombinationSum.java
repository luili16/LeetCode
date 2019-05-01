package com.llx278.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> combinationSum(int[] candidates, int target ) {
        recurse1(candidates,target,0,candidates.length);
        return null;
    }

    private void recurse1(int[] candidates,int target,int begin,int end) {

        if (begin == end) {
            return;
        }
        List<Integer> result = new ArrayList<>();
        int nextTarget = target;
        for (int i = begin; i < end; i++) {
            int num = candidates[i];
            if (nextTarget % num == 0) {
                // num可以被target整除
                int size = nextTarget / num;
                ArrayList<Integer> list = new ArrayList<>(result);
                for (int j = 0; j < size; j++) {
                    list.add(num);
                }
                System.out.println(list);
            }

            nextTarget = target - num;
            if (nextTarget < 0) {
                return;
            }
            result.add(num);
            if (nextTarget == 0) {
                System.out.println(result);
                result.remove(result.size() - 1);
            }
        }
    }

    private void recurse(int[] candidates,int target,int begin,int end,List<Integer> result) {
        System.out.println("begin:"+begin+"end:"+end);
        if (begin == end) {
            return;
        }

        int nextTarget = target;
        for (int i = begin; i < end; i++) {
            int num = candidates[i];
            if (nextTarget % num == 0) {
                // num可以被target整除
                int size = nextTarget / num;
                ArrayList<Integer> list = new ArrayList<>(result);
                for (int j = 0; j < size; j++) {
                    list.add(num);
                }
                System.out.println(list);
            }

            // 继续找下一个解
            nextTarget = nextTarget - num;
            if (nextTarget == 0) {
                System.out.println(num);
                result.clear();
                return;
            }

            if (nextTarget > 0) {
                result.add(num);
                recurse(candidates,nextTarget,i+1,end,result);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5};
        CombinationSum sum = new CombinationSum();
        sum.combinationSum(nums,8);
    }
}
