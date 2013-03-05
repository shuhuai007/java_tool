package com.zhoujie.pongo;

public class FullPermutation {

	public static final boolean isDebug = false;

	public void fullPermutateHelper(String str, String delimiter){
		String [] originalArr = str.split(delimiter);
		if (isDebug) {
			for (String element : originalArr) {
				System.out.print(element);
			}
		}

		int[][] locationArr = new int[getFactorial(originalArr.length)][originalArr.length];
		initLocationArr(locationArr);

		fullPermutate(originalArr, locationArr);

		printArr(originalArr, locationArr);

	}

	public void printArr(String[] strArr, int[][] locationArr) {
		for(int i = 0; i < locationArr.length; i ++){
			for(int j = 0; j < locationArr[i].length; j ++){
				print(String.valueOf(strArr[locationArr[i][j]]));
			}
			if (i != locationArr.length - 1) {
				print(",");
			}
		}

	}

	private void initLocationArr(int[][] locationArr) {
		for(int i = 0; i < locationArr.length; i ++){
			for(int j = 0; j < locationArr[i].length; j ++){
				locationArr[i][j] = -1;
			}
		}

	}

	public int getFactorial(int n){
		return computerFactorial(n);
	}

	private int computerFactorial(int n) {
		if(0 == n){
			return 0;
		}
		if(1 == n){
			return 1;
		}
		return n * computerFactorial(n - 1);
	}

	public void fullPermutate(String[] strArr, int [][] locationArr){
		int strLen = strArr.length;
		if (0 == strLen) {
			return;
		}

		if (1 == strLen) {
			locationArr[0][0] = 0;
			return;
		}

		String[] tmpArr = new String[strLen-1];
		for(int i = 0; i < strLen -1; i ++){
			tmpArr[i] = strArr[i] ;
		}
		fullPermutate(tmpArr, locationArr);
		// assume the first (strLen-1) has been fully permutated
		int fullPermutatedNum = getFactorial(strLen - 1);
		int [][]tmpLocationArr = new int[locationArr.length][locationArr[0].length];
		copyArr(locationArr, tmpLocationArr);
		for(int i = 0; i < fullPermutatedNum; i ++){
			for (int j = 0; j < strLen; j ++){
				// insert the last element to the jth location
				// j maybe 0, 1, 2, ..., strLen-2, strLen-1
				insertLastElement2Arr(tmpLocationArr, strLen, j, i, locationArr);
			}
		}
		
	}

	private void insertLastElement2Arr(int[][] tmpLocationArr, int strLen, int j, int i, int[][] locationArr) {
		int[] tmpArr = new int[tmpLocationArr[i].length];
		for (int index = 0; index < tmpLocationArr[i].length; index++) {
			tmpArr[index] = tmpLocationArr[i][index];
		}

		if (j < strLen -1){
			for (int index = strLen - 2; index >= j; index--) {
				tmpArr[index + 1] = tmpArr[index];
			}
		}
		tmpArr[j] = strLen - 1;
		for (int index = 0; index < tmpArr.length; index++) {
			locationArr[i * strLen + j][index] = tmpArr[index];
		}

	}

	public static void copyArr(int [][] arrayA, int [][]arrayB){
		for(int i = 0; i < arrayA.length; i ++){
			for(int j = 0; j < arrayA[i].length; j ++){
				arrayB[i][j] = arrayA[i][j];
			}
		}
	}

	public static void print(String str) {
		System.out.print(str);
	}
	public static void println(String str) {
		System.out.println(str);
	}

	public static void main(String [] args){
		String testStr = "1,2,3,4,5,6";
		FullPermutation instance = new FullPermutation();
		instance.fullPermutateHelper(testStr, ",");
	}

}
