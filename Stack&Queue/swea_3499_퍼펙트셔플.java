package com.inner;
import java.util.*;
import java.io.*;

public class Shuffle {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			Queue<String> queue1=new LinkedList<>();
			Queue<String> queue2=new LinkedList<>();
			int N=Integer.parseInt(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int idx=0;
			while(st.hasMoreTokens()) {
				String s=st.nextToken();
				if((idx<N/2&&N%2==0)||(idx<=N/2&&N%2==1))queue1.add(s);
				else queue2.add(s);
				idx++;
			}
			System.out.print("#"+(a+1)+" ");
			while(!queue1.isEmpty()) {
				System.out.print(queue1.remove()+" ");
				if(!queue2.isEmpty())
					System.out.print(queue2.remove()+" ");
			}
			System.out.println();
		}
	}
 
}
