package session2;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isHappyNumber(19));

	}

	private static boolean isHappyNumber(int n) {
		// TODO Auto-generated method stub
		Set<Integer> s = new HashSet<>();
		while(n!=1 && !s.contains(n)) {
			s.add(n);
			int x=0;
			while(n!=0) {
				x +=(n%10)*(n%10);
				n = n/10;
			}
			n=x;
		}
		return n==1;
	}

}
