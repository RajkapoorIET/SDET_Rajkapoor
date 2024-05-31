package session2;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,1};
		int k=3;
		int[] arr1 = {1,0,1,1};
		int k1=1;
		int[] arr2 = {1,2,3,1,2,3};
		int k2=2;
		System.out.println(isContainsDuplicates(arr,k));
		System.out.println(isContainsDuplicates(arr1,k1));
		System.out.println(isContainsDuplicates(arr2,k2));

	}

	private static boolean isContainsDuplicates(int[] arr, int k) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> m = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(i-m.getOrDefault(arr[i], -1000000)<=k) {
				return true;
			}
			m.put(arr[i], i);
		}
		return false;
	}

}
