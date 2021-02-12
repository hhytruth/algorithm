package algorithm.stack;
import java.util.*;
import java.io.*;

public class stack1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int testcase=1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s=br.readLine();
			if(s.contains("-"))break;
			int calculation=0;
			Stack<Character> stack=new Stack<>();
			for(int i=0;i<s.length();i++) {
				if(!stack.isEmpty()&&s.charAt(i)=='}'&&stack.peek()=='{') {
					stack.pop();
      }
				else stack.add(s.charAt(i));
			}
			while(!stack.isEmpty()) {
				char c=stack.pop();
				if(stack.isEmpty()) {
					calculation++;
					break;
				}
				if(c=='}'&&stack.peek()=='}') calculation++;
				else if(c=='{'&&stack.peek()=='{') calculation++;
				else if(c=='{'&&stack.peek()=='}') calculation+=2;
				stack.pop();
			}
			System.out.println(testcase+". "+calculation);
			testcase++;
			
		}
	}

}
