package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_2579_계단오르기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] stairs=new int[N];
		for(int i=0;i<N;i++) {
			stairs[i]=Integer.parseInt(br.readLine());
		}
		int[][] dp=new int[N][2];
		dp[0][0]=stairs[0];
		dp[0][1]=0;
		if(N==1) {
			System.out.println(stairs[0]);
			return;
		}
		dp[1][0]=stairs[1];
		dp[1][1]=dp[0][0]+stairs[1];
		
		for(int i=2;i<N;i++) {
			dp[i][0]=Math.max(dp[i-2][0]+stairs[i],dp[i-2][1]+stairs[i]);
			dp[i][1]=dp[i-1][0]+stairs[i];
		}
		
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
	}

}
