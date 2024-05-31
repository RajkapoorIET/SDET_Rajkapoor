package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThreeInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,3,7,1,0};
		int target = 6;
		threeSum(arr, target);

	}

	private static void threeSum(int[] arr, int target) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++) {
			int j=i+1, k=arr.length-1;
			while(j<k) {
				int sum = arr[i]+arr[j]+arr[k];
				if(sum==target) {
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					j++;
					k--;
				}
				else if(sum<target) {
					j++;
					
				}
				else {
					k--;
				}
			}
		}
		
	}

}
