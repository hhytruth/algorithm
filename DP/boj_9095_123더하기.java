package algorithm.dp;
import java.util.*;
import java.io.*;

public class boj_9095_123더하기 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int[] dp=new int[11];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=4;i<11;i++) {
			dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		}
		
		for(int a=0;a<T;a++) {
			int n=Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
