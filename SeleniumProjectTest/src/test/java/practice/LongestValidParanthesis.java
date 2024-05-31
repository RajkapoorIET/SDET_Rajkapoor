package practice;

import java.util.Stack;

public class LongestValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="()()()())())))";
		Stack<Integer> stack = new Stack();
	       stack.push(-1);
	        int startcount =0;
	        for(int i=0;i<s.length();i++){
	            if (s.charAt(i) == '(') 
	            stack.push(i);
	            else {
	                stack.pop();
	                if (stack.isEmpty())
	                 stack.push(i);

	                else
	                 startcount = Math.max(startcount, i - stack.peek());
	            }

	}
	        System.out.println(startcount);

}
}
