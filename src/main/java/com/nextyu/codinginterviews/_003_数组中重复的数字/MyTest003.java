package com.nextyu.codinginterviews._003_数组中重复的数字;

import cn.hutool.core.util.ArrayUtil;

public class MyTest003 {


    public static boolean duplicate(int[] array) {
        if (array == null || array.length < 2) {
            return false;
        }

        for (int i : array) {
            if (i < 0 || i > array.length - 1) {
                return false;
            }
        }


        int index = 0;
        boolean exist = false;

        while (index < array.length) {
            int indexValue = array[index];
            // 数字与下标不相等
            if (indexValue != index) {
                // 以数字为下标获取对应的值
                int indexValueValue = array[indexValue];
                if (indexValueValue == indexValue) {
                    exist = true;
                    System.out.println("重复：" + indexValueValue);
                    index++;
                } else {
                    // 交换 array[index] 和 array[indexValue]
                    array[index] = indexValueValue;
                    array[indexValue] = indexValue;
                }

            } else {
                index++;
            }

            System.out.println(ArrayUtil.toString(array));
        }


        System.out.println(ArrayUtil.toString(array));

        return exist;
    }


    public static void main(String[] args) {
        int[] array = {
                2, 3, 1, 0, 2, 5, 1
        };

        int[] array1 = {
                2, 3, 1, 0, 6, 5, 4
        };

        System.out.println(duplicate(array));
        System.out.println(duplicate(array1));
    }

}
