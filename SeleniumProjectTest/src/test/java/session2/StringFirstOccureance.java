package session2;

public class StringFirstOccureance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack="abc", needle="c";
		for(int i=0;i<haystack.length()-needle.length();i++){
			/*
			 * System.out.println(haystack.length()-i+"   "+needle.length());
			 * if((haystack.length()-i+1)<needle.length()) { break; }
			 */
			String cpmpare = haystack.substring(i,i+needle.length());
		    System.out.println(cpmpare);
	        if((needle.equals(cpmpare))){
	            System.out.println(i);
	            break;
	        } 
	        
		}

}
}
