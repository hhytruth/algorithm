package atest;
import java.io.*;
import java.util.*;

public class boj_14888_연산자끼워넣기 {

	static int[] numbers;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	
	public static void perm(char[] op,boolean[] visited,char[] result,int n,int depth) {
		
		if(depth==n-1) {
			int sum=numbers[0];
			for(int i=0;i<n;i++) {
				if(result[i]=='+')sum+=numbers[i+1];
				else if(result[i]=='-')sum-=numbers[i+1];
				else if(result[i]=='*')sum*=numbers[i+1];
				else if(result[i]=='/')sum/=numbers[i+1];
			}
			if(sum<min)min=sum;
			if(sum>max)max=sum;
			return;
		}
		
		for(int i=0;i<n-1;i++) {
			if(visited[i])continue;
			visited[i]=true;
			result[depth]=op[i];
			perm(op,visited,result,n,depth+1);
			visited[i]=false;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		numbers=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		int plusCount=Integer.parseInt(st.nextToken());
		int minusCount=Integer.parseInt(st.nextToken());
		int multiCount=Integer.parseInt(st.nextToken());
		int divideCount=Integer.parseInt(st.nextToken());
		
		char[] op=new char[N-1];
		int i=0;
		for(i=0;i<plusCount;i++) {
			op[i]='+';
		}
		for(;i<plusCount+minusCount;i++) {
			op[i]='-';
		}
		for(;i<plusCount+minusCount+multiCount;i++) {
			op[i]='*';
		}
		for(;i<N-1;i++) {
			op[i]='/';
		}
		
		perm(op,new boolean[N],new char[N],N,0);
		
		System.out.println(max);
		System.out.println(min);

	}

}
