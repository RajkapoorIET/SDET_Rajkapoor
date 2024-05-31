package session2;

import java.util.Arrays;

public class LongestConsicutiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//int arr[] = {3,2,1,5,4,6,32,003,2222,4};
		int arr[] = {0,3,7,2,5,8,4,6,0,1};
	 System.out.println(longestconsecutiveNumber(arr));

	}

	private static int longestconsecutiveNumber(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length<2) {
			return arr.length;
		}
		Arrays.sort(arr);
		int ans=1, t=1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]) {
				continue;
			}
			else if(arr[i]==arr[i-1]+1) {
				ans = Math.max(ans, ++t);
			}
			else {
				t=1;
			}
		}
		return ans;
	}

}
