package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_1699 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[100001];
		for(int i=1;i<=100000;i++) {
			dp[i]=i;
		}
		
		for(int i=1;i<=N;i++) {
			int square=1;
			while(square*square<=i) {
				dp[i]=Math.min(dp[i], dp[i-square*square]+1);
				square++;
			}
		}
		
		System.out.println(dp[N]);
	}

}
