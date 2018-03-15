package com.nextyu.codinginterviews._003_数组中重复的数字;

public class BinarySearch {
    public static int binSearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (target > array[mid]) {
                start = mid + 1;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static int binSearchRecursive(int[] array, int target, int start, int end) {
        int mid = (end - start) / 2 + start;
        if (target == array[mid]) {
            return mid;
        }

        if (start >= end) {
            return -1;
        } else if (target > array[mid]) {
            return binSearchRecursive(array, target, mid + 1, end);
        } else {
            return binSearchRecursive(array, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 6, 8, 99, 111, 999};
        System.out.println(binSearch(array, 666));
        System.out.println(binSearchRecursive(array, 666, 0, array.length - 1));
    }
}
