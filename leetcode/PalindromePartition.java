/**

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

**/

import java.util.ArrayList;
public class PalindromePartition {


	public static void main(String args[]) {

		PalindromePartition test = new PalindromePartition();
		ArrayList<ArrayList<String>> partitions = test.getAllPartitions("abba");
		test.printPartitions(partitions);

	}

	private ArrayList<ArrayList<String>> getAllPartitions(String s) {
		
		// for each prefix of s that is a palindrome, 
		// recursively get the palindrome partition of leftover string
		
		ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
		
		if(s.length() == 1){
     		   	partitions.add(new ArrayList<String>());
       			partitions.get(0).add(s);
        		return partitions;
    		}

    		if(s.length() == 0){
       			 partitions.add(new ArrayList<String>());
			partitions.get(0).add("");
     			 return partitions;
   		 }

		for (int i=1; i<= s.length(); i++) {
			if (isPalindrome(s.substring(0,i)))
			{
				ArrayList<ArrayList<String>> sub_partitions = getAllPartitions(s.substring(i));
				for (ArrayList<String> list: sub_partitions) {
					list.add(0, s.substring(0,i));
					partitions.add(list);
				}
			}
		}
		return partitions;

	}


	private boolean isPalindrome(String s) {

		boolean isPalin = true;
		int i=0;
		int j=s.length()-1;

		while (i<=j) {
			if (s.charAt(i)!=s.charAt(j))
 			{
				isPalin=false;
				break;	
			}
			i++;
			j--;
		}

		return isPalin;
	}

	private void printPartitions(ArrayList<ArrayList<String>> ll) {

		for (ArrayList<String> list: ll) {
			for (String s: list) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}

}
