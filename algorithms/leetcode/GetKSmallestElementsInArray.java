/**

Given an array of size n, find the k smallest elements of this array, 

Assume K is a constant, and do it with constant space complexity and linear time complexity

For instance， given array {5,6,4,3,1,2,9} and k=2, it will return {1,2}



*/



public class GetKSmallestElementsInArray {


	public static void main(String args[]) {


		int[]  arr = {7,8,9,4,5,6,1,2,3};

		int k = 9;

		GetKSmallestElementsInArray test = new GetKSmallestElementsInArray();

		int[] result = test.getKElements(arr, k);

		System.out.println("resulting array: ");
		for (int i=0; i< result.length; i++)
		 System.out.print(result[i]+ " ");


	}


	private int[] getKElements(int[] arr, int k) {


		int kthElement= getKthElement(arr, 0, arr.length-1, k);

		System.out.println("Kth element is "+ kthElement);
		int[] result = new int[k];
		int j=0;
		for (int i=0; i< arr.length; i++){
			if (arr[i]<= kthElement) {
				result[j]=arr[i];
				j++;
			}
		}
		return result;

	}


	private int getKthElement(int[] arr, int begin, int end,  int k) {

		if (begin==end)
			return arr[begin];
	
		int index = begin + (end - begin)/2;


		int newIndexOfPivot = partition(arr, begin, end, index);

		int adjustedIndex = newIndexOfPivot - begin + 1;

		if (adjustedIndex== k) {
			return arr[newIndexOfPivot];
		} else if (adjustedIndex< k){
			return getKthElement(arr, newIndexOfPivot+1, end, k-adjustedIndex);
		}  else
			return getKthElement(arr, begin, newIndexOfPivot-1, k);


	}


	private int partition(int[] arr, int begin, int end, int pivotIndex){

		
		int pivotValue = arr[pivotIndex];
     

		int i=begin;
		int j=begin;
		int temp;

		temp=arr[pivotIndex];
		arr[pivotIndex]= arr[end];
		arr[end]=temp;

		while (i<end) {

			if (arr[i]<=pivotValue) {

				// swap arr[i] and arr[j]
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;

				j++;	

			}
			i++;

		}

		temp=arr[end];
		arr[end]=arr[j];
		arr[j]=temp;

		return j;
	}












}
