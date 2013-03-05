package com.zhoujie.sort;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * backet sort
 * 
 * @author zhoujie
 * 
 */
public class BacketSort {
    public static final int ARRAY_LENGTH = 1000;
    public static final int ARRAY_MAX_VALUE = 10000;

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

        // 2. backet sort
        intArr = backetSort(intArr);

        // 3. print sorted array
        printLine(LOG_PREFIX + "The sorted array is:" + LOG_SUFFIX);
        printLine(join(intArr, ARR_DELIMITER));
    }

    private static int[] backetSort(int[] intArr) {
        int[] resultArr = new int[intArr.length];
        Map<Integer, ArrayList<Double>> map = new TreeMap<Integer, ArrayList<Double>>();
        double[] doubleArr = new double[intArr.length];
        int i = 0;
        for (int item : intArr) {
            doubleArr[i++] = item / (double) ARRAY_MAX_VALUE;
        }
        double step = 1 / (double) doubleArr.length;
        printLine("step:" + step);

        // insert into backet
        for (double item : doubleArr) {
            int backetIndex = (int) Math.floor(item * doubleArr.length);
            ArrayList<Double> list = map.get(backetIndex);
            if (list == null) {
                list = new ArrayList<Double>();
                map.put(backetIndex, list);
            }
            list.add(item);
        }

        int count = 0;
        // sort every backet
        for (int key : map.keySet()) {
            ArrayList<Double> list = map.get(key);
            int[] tempArr = new int[list.size()];
            int j = 0;
            for (double item : list) {
                tempArr[j++] = (int) (item * ARRAY_MAX_VALUE);
            }

            QuickSort.quickSort(tempArr);
            for (int item : tempArr) {
                resultArr[count++] = item;
            }
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
