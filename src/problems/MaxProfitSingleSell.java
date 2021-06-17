package problems;

public class MaxProfitSingleSell {
	
	// 10, 35, 3, 38, 48, 21, 88
	// 10, 38, 48, 21, 25, 92
	public static void main(String[] args) {
		int[] arr = {10, 38, 48, 21, 25, 92};
		
		new MaxProfitSingleSell().maxProfit(arr);
	}
	private void maxProfit(int[] arr) {
		
		int finalPurchaseIndex = 0;
		int finalSellIndex = 0;
		int maxProfit = 0;
		int currentMin = arr[0];
		int currentMax = arr[0];
		int currentPurchaseIndex = 0;
		// 10, 38, 48, 21, 3, 92
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] < currentMin) {
				currentPurchaseIndex = i;
				currentMin = arr[i];
			}
			
			int profit = arr[i] - currentMin;
			if (profit > currentMax) {
				maxProfit = profit;
				finalPurchaseIndex = currentPurchaseIndex;
				finalSellIndex = i;
			}
		}
		
		System.out.println("maxProfit : " + maxProfit + " and Pair : " + finalPurchaseIndex + ", " + finalSellIndex);
	}
}
