/**

Write C code to implement the strstr (Search for a substring) function. 
Do not use any system library such as strlen.



**/

public class ImplStrStr {

	// check if s2 is a substring of s1
	public boolean strStr(String s1, String s2) {

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();

		for (int i=0; i< arr1.length-arr2.length+1; i++) {
			boolean foundNonMatch = false;
			for (int j=i; j< arr2.length; j++) {
				if (arr1[j+i]!=arr2[j]) {
					foundNonMatch = true;
					break;
				}
			}
			
			if (!foundNonMatch))
				return true;
			

		} 

		return false;

	}







}
