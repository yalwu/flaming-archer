/**
what every one knows is one Fibonacci series which adds the previous 2 numbers i.e fib(n) = fib(n-1)+ fib(n-2). 
but there many Fibonacci series which adds the previous 2 numbers, previous 3 numbers and so on. 
So write a function fib(n,k) which gives you first n numbers of a Fibonacci series and k is the number of previous numbers you have to add ex.

for fib(n,3) you have to add fib(n-1)+ fib(n-2)+ fib(n-3)

**/

public class FibonacciSeries {

	public static void main(String args[]) {

	
		FibonacciSeries test = new FibonacciSeries();
		int k=3;
		int n=10;
		for (int i=0; i<n;i++)
			System.out.println("fib("+i+","+k+")="+test.fib(i,k));


	}
		
	public int fib(int n, int k) {
		if (n==0)
			return 0;
		else if (n==1)
			return 1;

 		if (n<k){
			int num=0;
			for (int i=0; i<=n-1;i++)
				num+=fib(i,k);	
			return num;
		}

		int num=0;
		for (int i=1; i<=k;i++) {
			num+=fib(n-i,k);
		}
		return num;
	}

}
