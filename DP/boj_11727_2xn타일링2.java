package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_11727_2xn타일링2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long[][] dp=new long[n+1][3];
		dp[1][1]=1;
		if(n==1) {
			System.out.println(1);
			return;
		}
		
		dp[2][0]=1;
		dp[2][1]=1;
		dp[2][2]=1;
		
		for(int i=3;i<=n;i++) {
			dp[i][0]=(dp[i-2][0]+dp[i-2][1]+dp[i-2][2])%10007;
			dp[i][1]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%10007;
			dp[i][2]=(dp[i-2][0]+dp[i-2][1]+dp[i-2][2])%10007;
		}
		
		System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%10007);
		
	}

}
