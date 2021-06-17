package problems.dp;

public class WaysToCoverStairs {
	
	//Can jump 1 or 2 steps in one go
	// N number of stairs are available
	// Number of ways to reach to Nth stair
	int[] cache = new int[100];
	
	public static void main(String[] args) {
		System.out.println(new WaysToCoverStairs().waysToReachNthStair(20));
	}
	private int waysToReachNthStair(int n) {
		
		return function(n+1); 
			
	}
	
	private int function(int s) {
		if (s <= 1) {
			return s;
		}
		
		if (cache[s] == 0) {
			cache[s] = function(s-1) + function(s-2);
		}
		
		return cache[s];
	}

}
