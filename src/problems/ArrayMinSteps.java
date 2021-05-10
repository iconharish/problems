package problems;

import java.util.Arrays;

public class ArrayMinSteps {
	public static void main(String[] args) {
		ArrayMinSteps obj = new ArrayMinSteps();
		
		int[] arrayIncreasing = {2, 2, 3, 4, 5, 6, 7}; // Answer = 3
		System.out.println(obj.getMinStepsToCoverArray(arrayIncreasing));
		
		int[] arrayDecreasing = {7, 6, 5, 4, 3, 2, 1}; // Answer = 1
		System.out.println(obj.getMinStepsToCoverArray(arrayDecreasing));
		
		int[] arraySame = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // Answer = 10
		System.out.println(obj.getMinStepsToCoverArray(arraySame));
		
		int[] arrayRandom = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; // Answer = 3
		System.out.println(obj.getMinStepsToCoverArray(arrayRandom));
		
		int[] arrayMix = {2, 2, 4, 4, 5, 6, 7}; // Answer = 2
		System.out.println(obj.getMinStepsToCoverArray(arrayMix));
		
		int[] arrayNull = {}; // Answer = 0
		System.out.println(obj.getMinStepsToCoverArray(arrayNull));
		
		int[] arrayOne = {1}; // Answer = 1
		System.out.println(obj.getMinStepsToCoverArray1(arrayOne));
		
	}
	
	private int getMinStepsToCoverArray(int[] array) {
		
		if (array.length == 0) {
			return 0;
		}
		
		int jumpCount = 1;
		int jumpIndex = 0;
		int jumpLength = array[jumpIndex];
		int currentMaxReachableIndex = jumpIndex + jumpLength;
		int nextMaxReachableIndex = currentMaxReachableIndex;
		
		for (int i = 1; i < array.length; i++) {
			if (i <= currentMaxReachableIndex) {
				if (nextMaxReachableIndex < i + array[i]) {
					nextMaxReachableIndex = i + array[i];
					jumpIndex = i;
				}
			} else {
				jumpCount ++;
				currentMaxReachableIndex = jumpIndex + array[jumpIndex];
				
			}
		}
		
		return jumpCount;
	}
	
	private int getMinStepsToCoverArray1(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		
		int[] temp = new int[arr.length];
		Arrays.fill(temp, Integer.MAX_VALUE);
		temp[0] = 0;
		
		boolean reachedEnd = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j <= i + arr[i] && j < arr.length; j++) {
				temp[j] = Math.min(temp[j], temp[i] + 1);
				if (j == arr.length - 1) {
					reachedEnd = true;
					break;
				}
			}
			if (reachedEnd) {
				break;
			}
		}
		
		return temp[arr.length - 1];
	}
}
