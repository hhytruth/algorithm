package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_2133_타일채우기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] dp=new int[N+1][7];
		if(N==1) {
			System.out.println(0);
			return;
		}
		dp[2][0]=1;
		dp[2][1]=1;
		dp[2][2]=1;
		dp[2][3]=1;
		dp[2][5]=1;
		
		for(int i=4;i<=N;i++) {
			if(i%2==1)continue;
			dp[i][0]=dp[i-2][0]+dp[i-2][1]+dp[i-2][2]+dp[i-2][4]+dp[i-2][6];
			dp[i][1]=dp[i][0];
			dp[i][2]=dp[i][0];
			for(int j=2;j<=i-2;j+=2) {
				dp[i][3]+=dp[j][0];
				dp[i][5]+=dp[j][0];
			}
			dp[i][4]=dp[i][3];
			dp[i][6]=dp[i][5];
		}
		
		int result=dp[N][0]+dp[N][1]+dp[N][2]+dp[N][4]+dp[N][6];
		//if(N==2)result=3;
		System.out.println(result);
		
	}

}
