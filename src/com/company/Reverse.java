package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Reverse {

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
