/**
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
The solution set must not contain duplicate triplets.

For example, given array S = {-1 0 1 2 -1 -4},

A solution set is:
(-1, 0, 1)
(-1, -1, 2)
**/

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum{


	public static void main(String[] args) {

		ThreeSum test = new ThreeSum();
		int[] testArr = {-1,0,1,2,-1,-4};
		ArrayList<ArrayList<Integer>> result= test.threeSum(testArr);
		System.out.println(result);
	
	}


	ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();		
		Arrays.sort(num);
		int a, b, c;
		int l,k;
		for (int i=0; i< num.length-3; i++ ) {
			a=num[i];
			l=i+1;
			k=num.length-1;
			while (l<k) {
				b=num[l];
				c=num[k];
				if (a+b+c == 0) {
					// all right we find it
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(a);
					list.add(b);
					list.add(c);
					result.add(list);
					k--;
					l++;

				}	
				else if (a+b+c>0)
					k--;
				else
					l++;

			}

		}
		return result;
	}


}
