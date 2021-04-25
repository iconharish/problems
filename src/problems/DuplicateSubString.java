package problems;

import java.util.HashMap;
import java.util.Map;

public class DuplicateSubString {
	
	public static void main(String[] args) {
		String str = "abcababcda";
		new DuplicateSubString().maxLengthDuplicateSubStrings(str);
	}
	
	void maxLengthDuplicateSubStrings(String str) {
		
		// iterate over the string for all 1 char strings and put in a map with count for them
		// iterate over the string for all 2 char strings and put in a map with count for them
		//... iterate over the string for all n/2 char strings and put in a map with count for them
		// above will be order of n^2, memory = n^2
		// iterate the map and print all duplicated sub strings - n^2
		// overall time complexity is n^2 and space complexity = n^2
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i <= str.length()/2; i++) {
			for (int j = 0; j <= str.length() - i; j++) {
				
				Integer count = map.get(str.substring(j, j+i));
				map.put(str.substring(j, j+i), count == null ? 1 : ++count);
			}
		}
		
		for (String subString : map.keySet()) {
			if (map.get(subString) != null && map.get(subString) > 1) {
				System.out.println(subString);
			}
		    
		}
		
		
	}
	
	// ab, abc, a, b, bc, c
	
}
