package problems;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] array = {1};
		int searchElement = 2;
		
		BinarySearch obj = new BinarySearch();
		System.out.println("Element Found : " + obj.isFound(array, searchElement));
	}
	
	private boolean isFound(int[] array, int searchElement) {
		int low = 0;
		int high = array.length - 1;
		
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (array[mid] < searchElement) {
				low = mid + 1;
			} else if (array[mid] > searchElement) {
				high = mid - 1;
			} else {
				return true;
			}
		}
		
		return false;
	}

}
