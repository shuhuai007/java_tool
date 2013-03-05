package com.zhoujie.sort;

import java.util.Random;

public class QuickSort {
	public static final int ARRAY_LENGTH = 10;
	public static final int ARRAY_MAX_VALUE = 1000;

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

		// 2. quick sort
		quickSort(intArr);
		// 3. print sorted array
		printLine(LOG_PREFIX + "The sorted array is:" + LOG_SUFFIX);
		printLine(join(intArr, ARR_DELIMITER));
	}

	public static void quickSort(int[] intArr) {
		quickSort(intArr, 0, (intArr.length-1));
	}

	private static void quickSort(int[] intArr, int i, int j) {
		int keyPoint = partition(intArr, i, j);
		
		if(i != keyPoint){
			quickSort(intArr, i, keyPoint-1);
		}
		if(j != keyPoint){
			quickSort(intArr, keyPoint+1, j);
		}
	}

	private static int partition(int[] intArr, int start, int end) {
		int keyWordValue = intArr[end];
		int shouldPos = start;
		/*
		 * shouldPos在for循环中应该满足循环不变式
		 * shouldPos: 
		 * 1. 在shouldPos（不包括它自己）之前的所有数据都小于等于keykeyWordValue
		 * 2. 在shouldPos（包括它自己）之后的所有数据都大于keykeyWordValue
		 */
		for(int i = start; i < end; i ++){
			if(intArr[i] > keyWordValue){
				// nothing to do
			} else {
				if(shouldPos != i){
					swap(intArr, shouldPos, i);
				}
				shouldPos ++;
			}
		}

		swap(intArr, shouldPos, end);
		return shouldPos;
	}

	private static void swap(int[] intArr, int i, int j) {
		int temp = intArr[j];
		intArr[j] = intArr[i];
		intArr[i] = temp;
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
