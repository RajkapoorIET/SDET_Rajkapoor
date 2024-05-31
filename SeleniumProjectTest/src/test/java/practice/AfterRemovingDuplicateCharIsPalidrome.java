package practice;

public class AfterRemovingDuplicateCharIsPalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "aabaa";
		//checkISPalindrome(s);
		System.out.println(isPalindrome(s));

	}

	private static void checkISPalindrome(String s) {
		// TODO Auto-generated method stub
		String newStr ="";
		newStr = String.valueOf(s.charAt(0));
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)!=s.charAt(i-1)) {
				newStr +=s.charAt(i);
			}
		}
		if(isPalindrome(newStr)) {
			System.out.println(newStr);
			System.out.println("Yes\n");
		}
		else
		{
			System.out.println(newStr);
			System.out.println("No\n");
		}
		
	}

	private static boolean isPalindrome(String newStr) {
		// TODO Auto-generated method stub
		int left =0;
		int right = newStr.length()-1;
		while(left<right) {
			if(newStr.charAt(left)!=newStr.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
