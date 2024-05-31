package session2;

public class ReverseArray {

	public static void main(String[] args) {
		
		int arr[] = {4,2,5,3,1,2,9};
		int start =0;
		int  end = arr.length-1;
		//System.out.println("actual array :"+arr.toString());
		reverseArray(arr,start,end);
		

	}

	private static void reverseArray(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		while(start<end) {
			int temp = arr[start];
			 arr[start] =arr[end];
			 arr[end] = temp;
			 start++;
			 end--;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" ");
		}
	}

}
