package com.nextyu.codinginterviews._004_二维数组中的查找;

public class MyTest004 {

    /**
     * 从右上角数字开始查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findRightUp(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length; // 数组的行数
        int cols = matrix[0].length; //数组的列数


        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int i = matrix[row][col]; // 右上角数字
            if (i == target) {
                return true;
            } else if (i > target) {
                col--; // 列数-1， 代表向左移动
            } else {
                row++; // 行数+1， 代表向下移动
            }

        }

        return false;
    }

    /**
     * 从左下角数字开始查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findLeftDown(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length; // 数组的行数
        int cols = matrix[0].length; //数组的列数


        int row = rows -1;
        int col = 0;

        while (col < cols && row >= 0) {
            int i = matrix[row][col]; // 左下角数字
            if (i == target) {
                return true;
            } else if (i > target) {
                row --; // 行数-1， 代表向上移动
            } else {
                col++; // 列数+1， 代表向右移动
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(findRightUp(matrix, 7));
        System.out.println(findRightUp(matrix, 17));
        System.out.println(findLeftDown(matrix, 7));
        System.out.println(findLeftDown(matrix, 17));
    }
}
