package session2;

public class FindProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,5,6,3};
		int arr1[] = {1,2,3,4};
		int arr2[] = {-1,1,0,-3,3};
		findProduct(arr);
		System.out.println();
		findProduct(arr1);
		System.out.println();
		findProduct(arr2);
		

	}

	private static void findProduct(int[] arr) {
		int temp =1;
		int result[] = new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			result[i] = temp;
			temp = temp*arr[i];
		}
		temp=1;
		for(int i=arr.length-1;i>=0;i--) {
			result[i]=temp*result[i];
			temp = temp*arr[i];
		}
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		
	}

}
