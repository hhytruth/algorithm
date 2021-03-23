package swing;
import java.io.*;
import java.util.*;


public class boj_1463_1로만들기 {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[N+1];
		dp[1]=0;
		
		for(int i=2;i<=N;i++) {
			int method1=Integer.MAX_VALUE;
			int method2=Integer.MAX_VALUE;
			int method3=Integer.MAX_VALUE;
			if(i%3==0)method1=dp[i/3]+1;
			if(i%2==0)method2=dp[i/2]+1;
			method3=dp[i-1]+1;
			
			int tmp=Math.min(method1, method2);
			dp[i]=Math.min(method3, tmp);
		}
		
		System.out.println(dp[N]);

	}
}
