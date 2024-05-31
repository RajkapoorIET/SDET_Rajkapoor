package practice;

public class NearestPalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 117;
          palidromeNumber(num);
	}

	private static void palidromeNumber(int num) {
		// TODO Auto-generated method stub
		int LPnum = num-1;
		while(isPalindrome(Integer.toString(LPnum))==false)
				{
			LPnum--;
		}
		int RPnum = num+1;
		while(isPalindrome(Integer.toString(RPnum))==false)
			{
			RPnum++;
			}
		
		if(Math.abs(num-LPnum)<Math.abs(num-RPnum)) {
			System.out.println(LPnum);
		}
		else
		{
			System.out.println(RPnum);
		}
		}


	private static boolean isPalindrome(String s) {
		// TODO Auto-generated method stub
		int left =0;
		int right=s.length()-1;
		while(left<right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
