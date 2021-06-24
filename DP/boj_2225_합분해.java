package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_2225_합분해 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[][] dp=new int[201][201];
		
		for(int i=1;i<=K;i++) {
			dp[i][0]=1;
		}
		
		for(int i=1;i<=K;i++) {
			for(int j=1;j<=N;j++) {
				dp[i][j]=(dp[i][j-1]+dp[i-1][j])%1000000000;
			}
		}
		
		System.out.println(dp[K][N]);
	}

}
