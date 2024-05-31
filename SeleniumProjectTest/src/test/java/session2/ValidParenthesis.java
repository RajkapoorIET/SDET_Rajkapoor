package session2;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		String input = sc.nextLine();
		System.out.println(isValid(input));
	}

	private static boolean isValid(String input) {
		// TODO Auto-generated method stub
		Stack<Character> s = new Stack<>();
		for(char c: input.toCharArray()) {
			if(c=='(' || c=='{' || c=='[') {
				s.push(c);
			}
			else {
				if(s.isEmpty()) {
					return false;
				}
				else {
					char top = s.peek();
					if((c==')' && top=='(') ||
					   (c=='}' && top=='{') || 
					   (c==']' && top=='[')){
						s.pop();
					}
					else {
						return false;
					}
				}
			}
			
		}
		
		return s.isEmpty();
	}

}
