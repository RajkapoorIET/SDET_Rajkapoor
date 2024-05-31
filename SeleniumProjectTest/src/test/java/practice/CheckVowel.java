package practice;

import java.util.Scanner;

public class CheckVowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String vowelchar = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				vowelchar =vowelchar+s.charAt(i);
			}

		}
		System.out.println(vowelchar);
	}

}
