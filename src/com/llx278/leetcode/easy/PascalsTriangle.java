package com.llx278.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) {
            return lists;
        }

        List<Integer> oneRow = new ArrayList<>();
        oneRow.add(1);
        lists.add(oneRow);
        if (numRows == 1) {
            return lists;
        }
        List<Integer> twoRow = new ArrayList<>();
        twoRow.add(1);
        twoRow.add(1);
        lists.add(twoRow);
        if (numRows == 2) {
            return lists;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> preRow = lists.get(i - 1 - 1);
            List<Integer> row = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    row.add(1);
                    continue;
                }

                if (j == i - 1) {
                    row.add(1);
                    continue;
                }

                int pre = preRow.get(j - 1);
                int next= preRow.get(j);
                row.add(pre + next);
            }
            lists.add(row);
        }
        return lists;
    }
}
