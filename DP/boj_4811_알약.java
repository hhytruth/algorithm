package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_4811_알약 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N;

		long[] dp=new long[31];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=30;i++) {
			long cnt=0;
			for(int j=0;j<i;j++) {
				cnt+=dp[j]*dp[i-1-j];
			}
			dp[i]=cnt;
		}
		
		while((N=Integer.parseInt(br.readLine()))!=0) {
			
			System.out.println(dp[N]);
		}
	}

}

