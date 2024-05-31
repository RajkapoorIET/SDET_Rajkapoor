package practice;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberInSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1,4,3,2};
		int n = arr.length;
		System.out.println(check(arr,n));

	}

	public static String check(int[] arr, int n) {
		// TODO Auto-generated method stub
		Map <Integer , Integer> m = new HashMap<>();
		for(int i=0;i<n;i++) {
			m.put(arr[i], 1);
			for(int j=i+1;j<n;j++) {
				m.put(arr[j],m.getOrDefault(arr[j],0)+1);
				System.out.println(m.getOrDefault(arr[j],0)+1 +"Value returns");
				boolean flag =false;
				
				for(Integer k:m.values()) {
					if(k==1) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					return "No";
				}
			}
			m.clear();
		}
		return "Yes";
	}

}
