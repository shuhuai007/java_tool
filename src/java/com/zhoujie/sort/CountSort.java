package com.zhoujie.sort;

import java.util.Random;

/**
 * heap sort
 * 
 * @author zhoujie
 * 
 */
public class CountSort {
    public static final int ARRAY_LENGTH = 10;
    public static final int ARRAY_MAX_VALUE = 100;

    public static final String LOG_PREFIX = "=====================";
    public static final String LOG_SUFFIX = LOG_PREFIX;
    public static final String ARR_DELIMITER = "\t";

    public static void main(String[] args) {
        // 1. generate input array
        Random random = new Random();

        int[] intArr = new int[ARRAY_LENGTH];
        printLine(LOG_PREFIX + "The original array is:" + LOG_SUFFIX);
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = random.nextInt(ARRAY_MAX_VALUE);
            print(intArr[i]);
            if (i != intArr.length - 1) {
                print(ARR_DELIMITER);
            }
        }
        printLine("");

        // 2. count sort
        int[] sortedArr = countSort(intArr);

        // 3. print sorted array
        printLine(LOG_PREFIX + "The sorted array is:" + LOG_SUFFIX);
        printLine(join(sortedArr, ARR_DELIMITER));
    }

    private static int[] countSort(int[] intArr) {
        int[] resultArr = new int[intArr.length];
        int[] countArr = new int[ARRAY_MAX_VALUE + 1];
        for (int i = 0; i < countArr.length; i++) {
            countArr[i] = 0;
        }
        for (int item : intArr) {
            countArr[item] = 1;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i - 1] + countArr[i];
        }
        for (int i = intArr.length - 1; i >= 0; i--) {
            int index = countArr[intArr[i]]--;
            resultArr[index - 1] = intArr[i];
        }
        return resultArr;
    }

    public static void print(Object t) {
        System.out.print(t);
    }

    public static void printLine(Object t) {
        System.out.println(t);
    }

    public static String join(int[] arr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int element : arr) {
            sb.append(element);
            sb.append(delimiter);
        }
        return sb.substring(0, sb.length());
    }

}
