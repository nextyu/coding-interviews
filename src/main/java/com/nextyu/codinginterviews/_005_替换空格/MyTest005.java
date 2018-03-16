package com.nextyu.codinginterviews._005_替换空格;

public class MyTest005 {

    /**
     * @param array      要替换的字符数组
     * @param usedLength 字符数组已经使用的长度
     */
    public static void replaceBlank(char[] array, int usedLength) {

        // 判断输入是否合法
        if (array == null || array.length < usedLength) {
            return;
        }

        // 统计字符数组中的空白字符数
        int blankCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (array[i] == ' ') {
                blankCount++;
            }
        }

        // 没有空白字符
        if (blankCount == 0) {
            return;
        }

        // 计算转换后的字符长度是多少
        int targetLength = blankCount * 2 + usedLength;
        // 转换后的长度大于数组的最大长度
        if (targetLength > array.length) {
            return;
        }

        // 从后向前处理
        int index1 = --usedLength;
        int index2 = --targetLength;

        while (index1 >= 0 && index1 < index2) {
            char temp = array[index1--];

            // 当前字符是空白字符，进行"%20"替换
            if (temp == ' ') {
                array[index2--] = '0';
                array[index2--] = '2';
                array[index2--] = '%';
            } else {
                // 把 array[index1] 移动到 array[index2]
                array[index2--] = temp;
            }

            System.out.println(index1 + "-" + index2);

        }

    }

    public static void main(String[] args) {
        String str = " a b c                                      ";
        String str2 = "a b c                                      ";
        String str3 = " a b  c                                      ";
        char[] chars = str.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] chars3 = str3.toCharArray();

//        replaceBlank(chars, 6);
        replaceBlank(chars2, 5);
        replaceBlank(chars3, 7);

//        System.out.println(chars);
        System.out.println(chars2);
        System.out.println(chars3);
    }

}
