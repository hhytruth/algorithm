package algorithm.dp;
import java.io.*;
import java.util.*;

public class boj_2169_로봇조종하기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp=new int[N][M];
		dp[0][0]=map[0][0];
		
		//dp 가장 윗 행 초기화
		for(int i=1;i<M;i++) {
			dp[0][i]=map[0][i]+dp[0][i-1];
		}
		
		int[][] temp=new int[2][M];
		for(int i=1;i<N;i++) {
			//left&up, up&right로 구하고 그 중 큰 값으로 dp set
			//왜냐하면 좌를 계산할 때 우가 안돼있기 때문에
			//left&up
			temp[0][0]=dp[i-1][0]+map[i][0];
			for(int j=1;j<M;j++) {
				temp[0][j]=Math.max(temp[0][j-1], dp[i-1][j])+map[i][j];
			}
			
			//right&up
			temp[1][M-1]=dp[i-1][M-1]+map[i][M-1];
			for(int j=M-2;j>=0;j--) {
				temp[1][j]=Math.max(temp[1][j+1], dp[i-1][j])+map[i][j];
			}
			
			for(int j=0;j<M;j++) {
				dp[i][j]=Math.max(temp[0][j], temp[1][j]);
			}
		}
		
		System.out.println(dp[N-1][M-1]);
		
	}

}
