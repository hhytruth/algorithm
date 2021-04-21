package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_9461_파도반수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		long[] dp=new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		for(int i=6;i<=100;i++) {
			dp[i]=dp[i-1]+dp[i-5];
		}
		for(int a=0;a<T;a++) {
			int N=Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}

}
