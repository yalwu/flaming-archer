/**

Given an array of integers, every element appears twice except for one. Find that single one.

**/

public class FindSingleNumber {

	public static void main(String args[]) {


		FindSingleNumber test = new FindSingleNumber();
		int[] testArr = {3,3,4,4,7,7,9,9,8,5,5};
		System.out.println(test.findSingleNum(testArr));

	}	


	private int findSingleNum(int[] arr) {
		int result=arr[0];

		for (int i=1; i< arr.length; i++) {

			result =  result ^ arr[i];

		}	

		return result;

	}

}
