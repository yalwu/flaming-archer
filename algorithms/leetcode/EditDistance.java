/**

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

**/
public class EditDistance {


	// take two string arguments 
	// will compute the edit distance of them
	public static void main(String args[]) {

		EditDistance test = new EditDistance();
	
		System.out.println("Edit Distance= "+test.getED(args[0], args[1]));

	}
	
	private int getED(String s1, String s2) {
		if (s1.isEmpty() && s2.isEmpty())
			return 0;
		else if (s1.isEmpty()) {
			return s2.length();
		}
		else if (s2.isEmpty()) {
			return s1.length();
		} else if (s1.charAt(0)==s2.charAt(0)) {
			return getED(s1.substring(1), s2.substring(1));
		}
		else 
		{
			int ed1=getED(s1.substring(1),s2)+1;
			int ed2=getED(s1, s2.substring(1))+1;
			int ed3=getED(s1.substring(1), s2.substring(1))+1;
			
			return Math.min(Math.min(ed1, ed2), ed3);

		}

	}

}
