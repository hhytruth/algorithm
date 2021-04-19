package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_10819_차이를최대로 {

	static int max=0;
	
	public static void solve(int N,Integer[] A,boolean[] visited,int[] result,int sum,int count,int cur) {
		
		if(count==N) {
			if(max<sum) {
				max=sum;
			}
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[count]=A[i];
				solve(N,A,visited,result,sum+Math.abs(cur-A[i]),count+1,A[i]);
				visited[i]=false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Integer[] A=new Integer[N];
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}

		boolean[] visited=new boolean[N];
		int[] result=new int[N];
		for(int i=0;i<N;i++) {
			visited[i]=true;
			result[0]=A[i];
			solve(N,A,visited,result,0,1,A[i]);
			visited[i]=false;
		}
		
		System.out.println(max);
		
	}

}
