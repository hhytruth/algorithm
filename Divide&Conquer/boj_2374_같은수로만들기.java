package algorithm.segment;
import java.util.*;
import java.io.*;

public class boj_2374_같은수로만들기 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<>();
		long result=0;
		//int max=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			int a=Integer.parseInt(br.readLine());
			if(stack.isEmpty()) {
				stack.push(a);
				if(min>a)min=a;
			//	if(max<a)max=a;
				continue;
			}
			else if(a==stack.peek())continue;
			
			if(a<min) {
				min=a;
				stack.push(a);
			}
			else if(stack.peek()<=a) {
			//	max=a;
				result+=a-min;
				while(!stack.isEmpty()&&stack.peek()<=a) {
					stack.pop();
				}
				stack.push(a);
				min=a;
			}
		}
		
		int max=0;
		min=Integer.MAX_VALUE;
		while(!stack.empty()) {
			int num=stack.pop();
			if(num>max)max=num;
			if(num<min)min=num;
		}
		result+=max-min;
		
		System.out.println(result);
		
	}	
}
