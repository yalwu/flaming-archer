/**

Given an array of strings, return all groups of strings that are anagrams.

*/
import java.util.List;
import java.util.ArrayList;

public class Anagrams {	

	public static void main(String args[]) {
				
		Anagrams test = new Anagrams();
		String[] inputArray = {"abc", "cba","ab", "ac", "ba"};
		List<List<String>> groups = test.returnGroupsOfAnagrams(inputArray);

		for (List<String> group: groups) {
			for (String s:group) {
				System.out.print(s+" ");
			}
			System.out.println();
		}

	}

	private List<List<String>> returnGroupsOfAnagrams (String[] input) {
		List<List<String>> groups = new ArrayList<List<String>>();
		for (int i=0; i< input.length; i++) {
			// find a group for input[i]			
			boolean foundGroup = false;
			for (List<String> group: groups) {
				if (isAnagram(group.get(0),input[i])) {	
					group.add(input[i]);
					foundGroup = true;
				}
					
			}
			if (!foundGroup) {
				List<String> anagramGroup = new ArrayList<String>();
				anagramGroup.add(input[i]);
				groups.add(anagramGroup);
			}
		}

		return groups;

	}
	
	private boolean isAnagram(String s1, String s2) {

		if (s1==null || s2==null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		else {
			int[] letters = new int[256];
			for (int i=0; i< s1.length();i++) {
				letters[s1.charAt(i)] ++;
				letters[s2.charAt(i)] --;
			}
			
			for (int i=0; i< letters.length; i++) {
				if (letters[i]!=0)
				   return false;	
			}
			return true;
		}
	}
}

