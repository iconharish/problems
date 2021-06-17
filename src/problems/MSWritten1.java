package problems;

public class MSWritten1 {
	// if lower and upper bound of a range are given as input, you need to return count of all numbers in the given range which can be represented as n * n+1
	
	public static void main(String[] args) {
		System.out.println(new MSWritten1().getCount(21, 1000000000));
	}
	
	public int getCount(int A, int B) {
		// n*(n+1) = n^2+n in range A to B
		// Using quadratic formula, n = (-b + sqrt(b^2 - 4ac))/2a -> need to check for n = -1 + sqrt(1+4A)/2 to -1 + sqrt(1+4B)/2
		// further simplifying -> -1/2 + sqrt(1/4 + X) -> -0.5 + sqrt(0.25 + X)
		
		double lower = Math.sqrt(0.25 + A) - 0.5;
		int lowerInt = (int)Math.ceil(lower);
		
		double upper = Math.sqrt(0.25 + B) - 0.5;
		int upperInt = (int)Math.floor(upper);
		
		if (lowerInt > upperInt) {
			return 0;
		}
		
		return upperInt - lowerInt + 1;
	}
}
