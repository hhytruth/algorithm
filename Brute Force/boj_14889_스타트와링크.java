package atest;
import java.io.*;
import java.util.*;

public class boj_14889_스타트와링크 {
	
	public static int[][] Smap;
	public static int min=Integer.MAX_VALUE;
	
	public static void comb(int N,int depth,int r,boolean[] visited,int[] result) {
		
		if(r==0) {
			int[] result2=new int[N/2];
			int sum1=0,sum2=0;
			int idx=0;
			for(int i=0;i<N;i++) {
				if(!visited[i]) result2[idx++]=i+1;
			}
			
			for(int i=0;i<N/2;i++) {
				for(int j=i+1;j<N/2;j++) {
					int n1=result[i];
					int n2=result[j];
					int n3=result2[i];
					int n4=result2[j];
					sum1+=Smap[n1-1][n2-1];
					sum1+=Smap[n2-1][n1-1];
					sum2+=Smap[n3-1][n4-1];
					sum2+=Smap[n4-1][n3-1];
				}
			}
			
			int diff=Math.abs(sum1-sum2);
			if(min>diff)min=diff;
			return;
		}
		
		if(depth==N)return;
		
		visited[depth]=true;
		result[N/2-r]=depth+1;
		comb(N,depth+1,r-1,visited,result);
		
		visited[depth]=false;
		comb(N,depth+1,r,visited,result);
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Smap=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				Smap[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		comb(N,0,N/2,new boolean[N],new int[N/2]);
		System.out.println(min);
	}

}
