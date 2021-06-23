package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_11057_오르막수 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] dp=new int[N+1][10];
		
		for(int i=0;i<10;i++) {
			dp[1][i]=1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j]=(dp[i][j]+dp[i-1][k])%10007;
				}
			}
		}
		
		int result=0;
		for(int i=0;i<10;i++) {
			result=(result+dp[N][i])%10007;
		}
		
		System.out.println(result);
		
	}

}
