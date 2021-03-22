package line2;
import java.util.*;
import java.io.*;

public class jungol_1681_해밀턴순환회로 {
 
	static int N;
	static int minSum=Integer.MAX_VALUE;
	
	public static void dfs(int[][] map,boolean[] visited,int sum,int count,int cur) {
		
		if(count==N-1) {
			
			if(map[cur][0]!=0&&sum+map[cur][0]<minSum) {
				minSum=sum+map[cur][0];
			}
			return;
		}
		if(sum>minSum)return;
		for(int i=1;i<N;i++) {
			if(!visited[i]&&map[cur][i]!=0) {
				visited[i]=true;
				dfs(map,visited,sum+map[cur][i],count+1,i);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visited=new boolean[N];
		visited[0]=true;
		dfs(map,visited,0,0,0);
		
		System.out.println(minSum);
	}

}
