package swing;
import java.io.*;
import java.util.*;


public class boj_14889_스타트와링크 {
	
	static int diff=Integer.MAX_VALUE;
	static int totalS=0,totalL=0;
	public static void comb(int[][] map,boolean[] visited,int[] result,int n,int r,int depth,int idx) {
		

		if(r==0) {
			int link=0,start=0;
			totalS=0;
			totalL=0;
			
			for(int i=0;i<n/2-1;i++) {
				for(int j=i+1;j<n/2;j++) {
					totalS+=map[result[i]][result[j]];
					totalS+=map[result[j]][result[i]];
				}
			}
			
			start=totalS;
			int[] result2=new int[n/2];
			int index=0;
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					result2[index]=i;
					index++;
				}
			}
			
			
			for(int i=0;i<n/2-1;i++) {
				for(int j=i+1;j<n/2;j++) {
					totalL+=map[result2[i]][result2[j]];
					totalL+=map[result2[j]][result2[i]];
				}
			}
			link=totalL;
			if(Math.abs(start-link)<diff)diff=Math.abs(start-link);
			return;
		}
		if(depth==n)return;
		visited[depth]=true;
		result[idx]=depth;
		comb(map,visited,result,n,r-1,depth+1,idx+1);
		
		visited[depth]=false;
		comb(map,visited,result,n,r,depth+1,idx);
	}
	

	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		boolean[] visited=new boolean[N];
		int[] result=new int[N/2];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int S=Integer.parseInt(st.nextToken());
				map[i][j]=S;
			}
		}
		comb(map,visited,result,N,N/2,0,0);
		System.out.println(diff);
		
	}

}
