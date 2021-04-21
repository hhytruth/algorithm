package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_2331_반복수열 {

	static int[] order=new int[1000001];
	static int answer=0;
	
	public static void dfs(int A,int P,int count) {
		
		if(order[A]>0) {
			answer=order[A]-1;
			return;
		}
		int next=0;
		int remain=A;
		int mul=10;
		while(remain!=0) {
			int tmp=(int)Math.pow((remain%mul)/(mul/10),P);
			next+=tmp;
			remain-=remain%mul;
			mul*=10;
		}
		if(next==A) {
			answer=count-1;
			return;
		}
		order[A]=count;
		dfs(next,P,count+1);
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		if(A==P) {
			System.out.println(0);
			return;
		}
		dfs(A,P,1);
		System.out.println(answer);
		
	}

}
