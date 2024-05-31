package session2;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		reverseNumbes(n);

	}

	private static void reverseNumbes(int n) {
		// TODO Auto-generated method stub
		boolean isNgeative = n<0;
		if(isNgeative)
		{
			n= n*-1;
		}
		long reverse = 0;
		
		while(n>0) {
			int lastDigit = n%10;
			reverse = reverse*10+lastDigit;
			n= n/10;
		}
		
	System.out.println(isNgeative? reverse*-1:reverse);
	}

}
