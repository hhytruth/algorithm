package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_9465_스티커 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int n=Integer.parseInt(br.readLine());
			int[][] stickers=new int[2][n+1];
			for(int i=0;i<2;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=1;j<=n;j++) {
					stickers[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp=new int[2][n+1];
			dp[0][1]=stickers[0][1];
			dp[1][1]=stickers[1][1];
			
			for(int i=2;i<=n;i++) {
				dp[0][i]=stickers[0][i]+Math.max(dp[1][i-1],dp[1][i-2]);
				dp[1][i]=stickers[1][i]+Math.max(dp[0][i-1], dp[0][i-2]);
			}
			
			System.out.println(Math.max(dp[0][n],dp[1][n]));
		}
	}

}
