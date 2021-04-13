package algorithm.stack;
import java.util.*;
import java.io.*;

public class boj_9935_문자열폭발 {

	public static void main(String[] args) throws Exception{	
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		String bomb=br.readLine();
		int blen=bomb.length();
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<input.length();i++) {
			char c=input.charAt(i);
			stack.add(c);
			if(c==bomb.charAt(blen-1)) {
				if(stack.size()<blen)continue;
				else {
					boolean explode=true;
					for(int j=0;j<blen;j++) {
						if(stack.get(stack.size()-1-j)!=bomb.charAt(blen-1-j)) {
							explode=false;
						}
					}
					if(explode) {
						for(int j=0;j<blen;j++)stack.pop();
					}
					
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(Character c: stack) {
			sb.append(c);
		}
		if(sb.length()==0)System.out.println("FRULA");
		else System.out.println(sb.toString());
	}	
}
