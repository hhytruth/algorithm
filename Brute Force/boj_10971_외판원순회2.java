package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_10971_외판원순회2 {

	static int N;
	static int[][] matrix;
	static int[][] dp;
	static int INF=1000000001;
	
	public static int TSP(int now,int visit) {
		
		if(visit==(1<<N)-1) {	//모든 정점을 방문했을 때
			if(matrix[now][0]==0)return INF;
			return matrix[now][0];
		}
		
		if(dp[now][visit]!=INF)return dp[now][visit];	//이미 값이 저장되어 있는 경우
		
		for(int i=0;i<N;i++) {
			int next=visit|(1<<i);
			if(matrix[now][i]==0||(visit&(1<<i))!=0)continue;	//i번째 노드에로의 길이 없거나 이미 방문한 경우
			dp[now][visit]=Math.min(dp[now][visit], TSP(i,next)+matrix[now][i]);
		}
		
		return dp[now][visit];
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		matrix=new int[N][N];
		dp=new int[N][(1<<N)-1];
		
		for(int i=0;i<N;i++)Arrays.fill(dp[i],INF);
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(TSP(0,1));
		
	}

}
