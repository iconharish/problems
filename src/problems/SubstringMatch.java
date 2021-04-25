package problems;

import java.util.Scanner;

public class SubstringMatch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String V = sc.nextLine();
		int N = sc.nextInt();
		sc.nextLine();
		String[] B = new String[N];
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextLine();
		}
		sc.close();
		
		char[] virusArray = V.toCharArray();
		
		
		for (int i = 0; i < N; i++) {
			char[] bloodArray  = B[i].toCharArray();
			int itemsToFind = bloodArray.length;
			int itemsToTraverse = virusArray.length;
			int bloodArrayIndex = 0;
			for (int j = 0; j < virusArray.length; j++) {
				if (itemsToFind > itemsToTraverse) {
					break;
				}
				if (virusArray[j] == bloodArray[bloodArrayIndex]) {
					itemsToFind --;
					bloodArrayIndex ++;
					
				}
				
				itemsToTraverse --;
				
				if (itemsToFind == 0) {
					System.out.println("POSITIVE");
					break;
				}
			}
			
			if (itemsToFind > 0) {
				System.out.println("NEGATIVE");
			}
		}
		
	}
}
