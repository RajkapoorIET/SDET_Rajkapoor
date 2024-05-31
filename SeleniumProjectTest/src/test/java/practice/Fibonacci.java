package practice;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num  = sc.nextInt();
		//fibonacciNumber(num);
		//System.out.println(
	   //         num + "th Fibonacci Number: " + fibonacciRecursion(num));
		for(int i=0;i<num;i++) {
			System.out.println(fibonacciNum(i)+ " ");
		}

	}

	private static int fibonacciNum(int num) {
		// TODO Auto-generated method stub
		if(num<=1) {
			return num;
		}
		
		return fibonacciNum(num-1)+fibonacciNum(num-2);
	}

	private static int fibonacciRecursion(int num) {
		// TODO Auto-generated method stub
		{
	        if (num <= 1)
	            return num;
	        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
	    }
		
		
	}

	private static void fibonacciNumber(int num) {
		// TODO Auto-generated method stub
		int f= 0;
		int f1=1;
		int f2=1;
		
		for(int i=1;i<=num;i++) {
			System.out.println(f);
			f=f1;
			f1=f2;
			f2 = f+f1;
					
		}
		
	}

}
