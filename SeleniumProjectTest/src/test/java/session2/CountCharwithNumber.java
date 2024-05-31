package session2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//This program will take inpit from user as a String and calculate the number and duplicate
// char count and display output as char with numbers e.g 'a3b5n6'
public class CountCharwithNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc =new Scanner(System.in);
      String str = sc.next();
      System.out.println(charCount(str));
	}

	private static String charCount(String str) {
		// TODO Auto-generated method stub
		String result ="";
		HashMap<Character, Integer> hm = new HashMap<>();
		for(char c:str.toCharArray()) {
			if(hm.containsKey(c)) {
				hm.put(c, hm.getOrDefault(c, 1)+1);
			}
			else
			{
				hm.put(c,1);
			}
		}
		for(Map.Entry<Character,Integer> entry:hm.entrySet()) {
			result +=""+entry.getKey()+entry.getValue();
			if(entry.getValue()==1) {
				System.out.println("First Non repeating char  "+entry.getKey());
			}
		}
		return result;
	}

}
