package com.zhoujie.sort;

import java.util.Random;

/**
 * heap sort
 * 
 * @author zhoujie
 * 
 */
public class HeapSort {
    public static final int ARRAY_LENGTH = 10;
    public static final int ARRAY_MAX_VALUE = 100;

    public static final String LOG_PREFIX = "=====================";
    public static final String LOG_SUFFIX = LOG_PREFIX;
    public static final String ARR_DELIMITER = "\t";

    private static int heapSize = ARRAY_LENGTH;

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

        // 2. insert sort
        heapSort(intArr);

        // 3. print sorted array
        printLine(LOG_PREFIX + "The sorted array is:" + LOG_SUFFIX);
        printLine(join(intArr, ARR_DELIMITER));
    }

    public static void heapSort(int[] intArr) {
        buildMaxHeap(intArr);
        for (int i = intArr.length - 1; i > 0; i--) {
            swap(intArr, 0, i);
            heapSize--;
            maxHeapify(intArr, 0);
        }
    }

    private static void swap(int[] intArr, int i, int j) {
        int temp = intArr[j];
        intArr[j] = intArr[i];
        intArr[i] = temp;
    }

    private static void maxHeapify(int[] intArr, int i) {
        int leftIndex = leftChildIndex(i);
        int rightIndex = rightChildIndex(i);
        int largest = i;
        if (leftIndex <= (heapSize - 1) && intArr[leftIndex] > intArr[i]) {
            largest = leftIndex;
        } else {
            largest = i;
        }

        if (rightIndex <= (heapSize - 1)
                && intArr[rightIndex] > intArr[largest]) {
            largest = rightIndex;
        }
        if (largest != i) {
            swap(intArr, i, largest);
            maxHeapify(intArr, largest);
        }
    }

    private static int rightChildIndex(int i) {
        return (2 * i + 2);
    }

    private static int leftChildIndex(int i) {
        return (2 * i + 1);
    }

    private static void buildMaxHeap(int[] intArr) {
        heapSize = intArr.length;
        for (int i = intArr.length / 2; i >= 0; i--) {
            maxHeapify(intArr, i);
        }
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
