package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_1912_연속합 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] dp=new int[n];
		dp[0]=arr[0];
		int max=arr[0];
		for(int i=1;i<n;i++) {
			if(arr[i]+dp[i-1]>arr[i]) dp[i]=arr[i]+dp[i-1];
			else dp[i]=arr[i];
			if(dp[i]>max)max=dp[i];
		}
		
		System.out.println(max);
	}

}
