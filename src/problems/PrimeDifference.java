package problems;

import java.util.Scanner;

public class PrimeDifference {
	
	public static void main(String[] args) {
		
		int maxRange = 1000000;
		boolean[] prime = new boolean[maxRange+1];
		
		for(int i = 2; i <= maxRange; i++) {
			prime[i] = true;
		}
		
		for (int j = 2; j * j <= maxRange; j++) {
			if (prime[j]) {
				for (int i = j * j; i <= maxRange; i+=j) {
					prime[i] = false;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		int[] L = new int[T];
		int[] R = new int[T];
		int[] results = new int[T];
		
		
		for (int i = 0; i < T; i++) {
			L[i] = sc.nextInt();
			R[i] = sc.nextInt();
			sc.nextLine();
			
			int lowestPrime = 0;
			int highestPrime = 0;
			
			for (int j = L[i]; j <= R[i]; j++) {
				if (prime[j]) {
					lowestPrime = j;
					break;
				}
			}
			
			for (int j = R[i]; j >= L[i]; j--) {
				if (prime[j]) {
					highestPrime = j;
					break;
				}
			}
			
			if (lowestPrime == 0 && highestPrime == 0) {
				results[i] = -1;
			} else {
				results[i] = highestPrime - lowestPrime;
			}
			
		}
		
		sc.close();
		
		for (int i = 0; i < T; i++) {
			System.out.println(results[i]);
		}
	}
}