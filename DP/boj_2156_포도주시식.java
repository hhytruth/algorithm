package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_2156_포도주시식 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] wines=new int[n];
		for(int i=0;i<n;i++) {
			wines[i]=Integer.parseInt(br.readLine());
		}
		int[][] dp=new int[n][3];
		dp[0][1]=wines[0];
		
		for(int i=1;i<n;i++) {
			dp[i][0]=Integer.max(Integer.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			dp[i][1]=dp[i-1][0]+wines[i];
			dp[i][2]=dp[i-1][1]+wines[i];
		}
		
		System.out.println(Integer.max(Integer.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
		
	}

}
