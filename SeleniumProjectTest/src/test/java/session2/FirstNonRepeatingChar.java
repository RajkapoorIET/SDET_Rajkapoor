package session2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "racecar";
		System.out.println("First Non Repeated char indice from given String :"+firstNonRepeatingCharIndex(str));

	}

	private static int firstNonRepeatingCharIndex(String str) {
		// TODO Auto-generated method stub
		Map<Character,Integer> m = new HashMap<>();
		for(char c:str.toCharArray()) {
			m.put(c, m.getOrDefault(c, 0)+1);
		}
		for(Map.Entry<Character, Integer> e:m.entrySet()) {
			if(e.getValue()==1) {
				System.out.println("First Non Repeated Char from given String : "+e.getKey());
			}
		}
		for(int i = 0;i<str.length();i++) {
			char[] arr = str.toCharArray();
			if(m.get(arr[i])==1) {
				return i;
			}
		}
		
		return -1;
	}

}
