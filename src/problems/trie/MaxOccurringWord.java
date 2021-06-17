package problems.trie;

import java.util.Arrays;
import java.util.List;

public class MaxOccurringWord {

	
	
	static class TrieNode {
		String word;
		int count;
		TrieNode[] children = new TrieNode[26];
	}
	
	public static void main(String[] args) {
		List<String> dict = Arrays.asList(
			"code", "coder", "coding", "codable", "codec", "codecs", "coded",
			"codeless", "codec", "codecs", "codependence", "codex", "codify",
			"codependents", "codes", "code", "coder", "codesign", "codec",
			"codeveloper", "codrive", "codec", "codecs", "codiscovered"
		);
		
		TrieNode root = new TrieNode();
		for (String word : dict) {
			insert(root, word);
		}
		
		int count = 0;
		StringBuilder word = new StringBuilder();
		
		count = traverse(root, count, word);
		
		System.out.println("Word : " + word);
		System.out.println("Count : " + count);
	}
	
	private static void insert(TrieNode root, String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children[c-'a'] == null) {
				curr.children[c-'a'] = new TrieNode();
			}
			curr = curr.children[c-'a'];
		}
		curr.word = word;
		curr.count += 1;
	}
	
	private static int traverse(TrieNode curr, int maxCount, StringBuilder word) {
		if (curr == null) {
			return maxCount;
		}
		
		for (int i = 0; i < 26; i++) {
			TrieNode child = curr.children[i];
			if (child != null) {
				if (maxCount < child.count) {
					word.replace(0, word.length(), child.word);
					maxCount = child.count;
				}
				maxCount = traverse(child, maxCount, word);
			}
		}
		
		return maxCount;
	}
}