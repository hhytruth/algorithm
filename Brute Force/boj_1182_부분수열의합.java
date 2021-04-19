package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_1182_부분수열의합 {

	static int S;
	static int result=0;
	
	public static void subset(int[] arr,boolean[] visited,int n,int count,int sum) {
		
		if(count==n) {
			if(S==sum)result++;
			return;
		}
		
		visited[count]=false;
		subset(arr,visited,n,count+1,sum);
		visited[count]=true;
		subset(arr,visited,n,count+1,sum+arr[count]);
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		boolean[] visited=new boolean[N];
		subset(arr,visited,N,0,0);
		if(S==0)result--;
		System.out.println(result);
		
	}

}
