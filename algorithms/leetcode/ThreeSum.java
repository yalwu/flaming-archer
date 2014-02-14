/**

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
For example, given array S = [-1,0,1,2,-1,-4],

A solution set is:

[
  [-1, 0, 1],
  [-1, -1, 2]
]


**/
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String args[]) {

		int[] arr = {-1,0,1,2,-1,-4};
		ThreeSum test = new ThreeSum();

		ArrayList<ArrayList<Integer>> result = test.threeSum(arr);
	
		for (ArrayList<Integer> triplet: result) {
			System.out.println(triplet);
		
		}
	}
	

	public ArrayList<ArrayList<Integer>> threeSum(int[] arr) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(arr);

		
		int n= arr.length;
		for (int i=0; i<n-2; i++) {
			// skip if same as previous element
			if (i>0 && arr[i]==arr[i-1])
				continue;
			
			// look for pair in arr[i+1....n] that adds up -arr[i]
			int j=i+1;
			int k=n-1;
			boolean isFound=false;
			while (j<=k) {
				if ((arr[j]+ arr[k])> (-arr[i])) {
					k--;	
				} else if ((arr[j]+ arr[k])< (-arr[i]))
				{
					j++;
				} else {
					isFound=true;
				}

				// found one triplet!
	                       if (isFound) {
        	                        ArrayList<Integer> triplet = new ArrayList<Integer>();
                	                triplet.add(arr[i]);
                        	        triplet.add(arr[j]);
                                	triplet.add(arr[k]);
                                  	result.add(triplet);
					isFound=false;
					j++;
					k--;
                        	}
			}

		}
		return result;
	}

}
