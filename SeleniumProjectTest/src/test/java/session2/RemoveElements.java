package session2;

import java.util.Arrays;

public class RemoveElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,0,2,3,8,4,3,2,0,5,4,3,4,3};
		int k=3;
		System.out.println(removeElements(arr, k));
		System.out.println(removeDuplicates(arr));

	}

	private static int removeDuplicates(int[] arr) {
		// TODO Auto-generated method stub
		int i=1;
		Arrays.sort(arr);
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]);
		}
		for(int j=1;j<arr.length;j++) {
			if(arr[j-1]!=arr[j]) {
				arr[i]=arr[j];
				i++;
			}
		}
		int[] result = new int[i];
		for(int k=0;k<i;k++) {
			result[k]=arr[k];
		}
		System.out.println();
		for(int k=0;k<result.length;k++) {
			System.out.print(result[k]);
		}
		System.out.println();
		return i;
	}

	private static int removeElements(int[] arr, int k) {
		// TODO Auto-generated method stub
		int i=0;
		for(int j=0;j<arr.length;j++) {
			if(arr[j]!=k) {
				arr[i]=arr[j];
				i++;
			}
		}
		int[] result = new int[i];
		for(int l=0;l<i;l++) {
			result[l]=arr[l];
		}
		for(int l=0;l<result.length;l++) {
			System.out.print(result[l]);
		}
		System.out.println();
		return i;
	}

}
