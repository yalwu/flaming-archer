/**

Given an integer n, find the number of trailing zeros of 
the factorial of n, that is n!= n*(n-1)*(n-2)*(n-3)*..*1


**/



public class GetTrailingZeroOfFactorial {



	public static void main(String args[]) {


		GetTrailingZeroOfFactorial test = new GetTrailingZeroOfFactorial();

		System.out.println("num="+ test.getNumOfTrailingZero(10));




	}

	public int getNumOfTrailingZero(int n){

		// find how much (2*5) there are in n!
		// since 5 is less frequence, the num
		// of 5 becomes dominant


		int num5=0;
		for (int i=n; i>0; i--) {

			if (i%5==0) {
				num5+=(Math.log(i)/Math.log(5));
			}


		}

		return num5;

	}


}
