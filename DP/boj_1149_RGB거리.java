package swing;
import java.io.*;
import java.util.*;


public class boj_1149_RGB거리 {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] costs=new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int cost=Integer.parseInt(st.nextToken());
				costs[i][j]=cost;
			}
		}
		
		int[][] dp=new int[N][3];
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				if(i==0) dp[i][j]=costs[i][j];
				else {
					if(j==0) dp[i][j]=Math.min(dp[i-1][1], dp[i-1][2])+costs[i][j];
					else if(j==1) dp[i][j]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i][j];
					else dp[i][j]=Math.min(dp[i-1][0],dp[i-1][1])+costs[i][j];
				}
			}
		}
		
		int tmp=Math.min(dp[N-1][0],dp[N-1][1]);
		int result=Math.min(tmp, dp[N-1][2]);
		System.out.println(result);

	}
}
