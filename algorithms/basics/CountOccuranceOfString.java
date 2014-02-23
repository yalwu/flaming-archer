/**
find the substring count from a string without string functions in java? 
Given String str = "abcdefghcde"; 
String find = "cde"; 
Count occurrences of cde in String str

**/

public class CountOccuranceOfString {


	public static void main(String args[]) {

		CountOccuranceOfString test = new CountOccuranceOfString();
		int num = test.countOccuranceofString("abcdefghcde", "cde");
		System.out.println("num="+num);	
	

	}

	public int countOccuranceofString(String str, String sub) {

		char[] strArr = str.toCharArray();
		char[] subArr = sub.toCharArray();

		int numMatch = 0;
		for (int i=0; i< strArr.length-subArr.length+1; i++) {
			boolean isMatch=true;
			for (int j=0; j<subArr.length; j++) {
				if (strArr[i+j]!=subArr[j])
					isMatch = false;
			}
			if (!isMatch)
                        	continue;
                       	else
				numMatch++;

		}
		return numMatch;

	}





}
