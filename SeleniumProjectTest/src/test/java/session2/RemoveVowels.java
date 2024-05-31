package session2;

import java.util.Set;

public class RemoveVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "lets have a cup of tea";
		Set<Character> set = Set.of('a','e','i','o','u');
		StringBuilder sb =  new StringBuilder();
		for(char c:str.toCharArray()) {
			if(!set.contains(c)) {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());

	}

}
