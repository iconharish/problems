package problems;

import java.util.Arrays;

public class ReverseArray {
	
	public static void main(String[] args) {
		ReverseArray obj = new ReverseArray();
		
		int[] arrayOdd = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(obj.getReversedArray(arrayOdd)));
		
		int[] arrayEven = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(Arrays.toString(obj.getReversedArray(arrayEven)));
		
		int[] arrayNull = {};
		System.out.println(Arrays.toString(obj.getReversedArray(arrayNull)));
		
		int[] arrayOne = {1};
		System.out.println(Arrays.toString(obj.getReversedArray(arrayOne)));
		
	}
	
	private int[] getReversedArray (int[] array) {
		
		int low = 0;
		int high = array.length - 1;
		
		while(low < high) {
			swap(array, low, high);
			low ++;
			high --;
		}
		
		return array;
	}
	
	private void swap (int[] array, int i, int j) {
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
	
}
