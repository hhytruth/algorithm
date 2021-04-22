package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int max=0;
		int[] arr=new int[N];
		int[] first=new int[1001];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(st.nextToken());
			arr[i]=num;
			first[num]=i;
		}
		int[] dp=new int[N];
		dp[0]=1;
		max=1;
		
		for(int i=1;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]&&dp[j]+1>dp[i]) {
					dp[i]=dp[j]+1;
					if(max<dp[i])max=dp[i];
				}
			}
		}
		
		System.out.println(max);
	}

}
