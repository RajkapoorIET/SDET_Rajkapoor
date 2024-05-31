package session2;

import java.util.Arrays;
import java.util.HashMap;

public class IndicesOfGivenSumfromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,11,5,10,7,8};
		int target = 9;
		indicesofTargetSum(arr, target);
		indicesofTargetSum2(arr, target);
		

	}
//approach-1
	private static void indicesofTargetSum(int[] arr, int target) {
		// TODO Auto-generated method stub
		int[] result = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(!hm.containsKey(target-arr[i])) {
				hm.put(arr[i], i);
			}
			else {
				result[1]=i;
				result[0] = hm.get(target-arr[i]);
				break;
			}
		}
		System.out.println("Indices of "+result[0] +" and "+result[1]);
		
		
		
	}
	
 //approach-2
	private static void indicesofTargetSum2(int[] arr, int target) {
		// TODO Auto-generated method stub
		int[] result = new int[2];
		Arrays.sort(arr);
		int start =0;
		int end = arr.length-1;
		while(start<end) {
			int sum = arr[start]+arr[end];
			if(sum==target) {
				result[0]=arr[start];
				result[1] =arr[end];
				break;
			}
			else if(sum<target) {
				start++;
			}
			else {
				end--;
			}
		}
		
		System.out.println("Value of two sum "+result[0]+" and "+result[1]);
	}

}
