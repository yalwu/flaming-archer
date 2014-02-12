/**

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

*/

public class GenerateParenthesis {


	public static void main(String args[]) {
		

		generateParen(3,0, "");


	}


	private static void generateParen(int open, int close, String s) {
		if (open==0 && close==0 ) {
                    System.out.println(s);
		}
		else {
			
			if (open>0)
				generateParen(open-1, close+1, s+'(' );
			if (close>0)
				generateParen(open,close-1, s+')' );


		}
			


	}



}
