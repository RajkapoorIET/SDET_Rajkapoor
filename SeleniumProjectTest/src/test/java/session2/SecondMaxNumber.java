package session2;

public class SecondMaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,34,5,6,8,33,5,34,22,34,2};
		secondmMax(arr);
		secondMin(arr);

	}

	private static void secondMin(int[] arr) {
		// TODO Auto-generated method stub
		int secondMin = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				secondMin = min;
				min =arr[i];
			}
			else if (arr[i] < secondMin && arr[i]!=min ) {
				secondMin =arr[i];
			}
		}
		System.out.println("Second Min number from the array :" +secondMin);
		
	}

	private static void secondmMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondmax = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				secondmax = max;
				max =arr[i];
			}
			else if (arr[i] > secondmax && arr[i]!=max ) {
				secondmax =arr[i];
			}
		}
		System.out.println("Second max from the given array :"+secondmax);
		
		
	}

}
