package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] dp=new int[N];
		dp[0]=1;
		int max=1;
		
		for(int i=1;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]<arr[j]&&dp[j]+1>dp[i]) {
					dp[i]=dp[j]+1;
					if(max<dp[i])max=dp[i];
				}
			}
		}
		
		System.out.println(max);
		
	}

}
