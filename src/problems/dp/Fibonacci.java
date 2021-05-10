package problems.dp;

public class Fibonacci {
	
	final int MAX = 1000;
	int[] cache = new int[MAX];
	
	public static void main(String[] args) {
		System.out.println(new Fibonacci().fib(400));
	}
	
	int fib (int n) {
		
		if (n <= 1) {
			return n;
		}
		
		if (cache[n] == 0) {
			cache[n] = fib(n-1) + fib(n-2);
		}
		
		return cache[n];
		
	}

}
