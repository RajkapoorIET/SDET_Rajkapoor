package session2;

public class MaxSumofSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[] = {2,4,8,1,34,-13,12,41};
		int arr[] = {4,3,-2,6,-12,7,-1,6};
		
		System.out.println("Max of given subarray sum: "+maxSubArraySum(arr));

	}

	private static int maxSubArraySum(int[] arr) {
		// TODO Auto-generated method stub
		int maxsofar = arr[0];
		int currentmax = arr[0];
		for(int i=1;i<arr.length;i++) {
			currentmax = currentmax+arr[i];
			 if(currentmax<arr[i]) {
				 currentmax = arr[i];
			 }
			 if(maxsofar<currentmax) {
				 maxsofar = currentmax;
			 }
		}
		
		
		return maxsofar;
	}

}
