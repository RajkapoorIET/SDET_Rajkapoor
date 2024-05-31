package practice;

import java.util.Scanner;

public class MissingNumberfromArray {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number in between you want to find the missing numbber");
		int n=sc.nextInt();
		int num[] = new int[n];
		int SumArr=0;
		for(int i =0;i<n;i++) {
			num[i]=sc.nextInt();
		}
		for(int i =0; i<=n-2;i++) {
			SumArr = SumArr+num[i];
		}
		int sum = (n*(n+1))/2;
		System.out.println(sum-SumArr);
		
	}

}
