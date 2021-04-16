package swing;

import java.util.*;
import java.io.*;

public class boj_3015_오아시스재결합 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] heights=new int[N];
		for(int i=0;i<N;i++) {
			heights[i]=Integer.parseInt(br.readLine());
		}
		
		Stack<Integer[]> stack=new Stack<>();
		long sum=0;
		for(int i=0;i<N;i++) {

			Integer[] cur= {heights[i],1};
			while(!stack.isEmpty()&&stack.peek()[0]<heights[i]) {
				sum+=stack.peek()[1];
				stack.pop();
			}
			
			if(stack.isEmpty())stack.add(new Integer[] {heights[i],1});
			else {
				if(stack.peek()[0]==(int)cur[0]) {				
					sum+=stack.peek()[1];
					Integer[] next=stack.pop();
					if(!stack.isEmpty())sum++;
					next[1]++;
					stack.add(next);
				}
				else {
					stack.add(cur);
					sum++;
				}
			}
		}
		
		System.out.println(sum);
	}

}
