package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_1890_점프 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		long[][] dp=new long[N][N];
		dp[0][0]=1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int num=map[i][j];
				if(num==0)continue;
				
				if(i+num<N)dp[i+num][j]+=dp[i][j];
				if(j+num<N)dp[i][j+num]+=dp[i][j];
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
	}

}
