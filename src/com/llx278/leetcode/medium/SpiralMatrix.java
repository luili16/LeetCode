package com.llx278.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {


        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("m = " + m);
        System.out.println("n = " + n);

        printSubArray(matrix,0,0,3,3);
        return new ArrayList<>();
    }

    public void printSubArray(int[][] matrix,int x,int y,int m,int n) {

        for (int i = y; i < m - x; i++) {
            System.out.print(matrix[x][i]);
        }
        System.out.println(' ');
        for (int j = x + m; j < n - y;j++) {
            System.out.print(matrix[j][y]);
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[][] a =  {
            {1,2,3},
            { 4,5,6},
                {7,8,9}
        };

        List<Integer> list = new SpiralMatrix().spiralOrder(a);
        System.out.println(list);


    }
}
