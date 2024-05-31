package practice;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(isPalindrome(Integer.toString(num))) {
			System.out.println("Given number is palindrome " +num);
		}
		else
		{
			System.out.println("Given number is not palindrome "+num);
		}

	}

	private static boolean isPalindrome(String string) {
		// TODO Auto-generated method stub
		int left =0;
		int right = string.length()-1;
		while(left<right) {
			if(string.charAt(left) !=string.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
