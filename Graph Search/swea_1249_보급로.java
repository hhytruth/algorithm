package line;
import java.util.*;
import java.io.*;

public class route {
    
	static int result=Integer.MAX_VALUE;
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,1,-1,0};
	static int N;
	
	public static void dfs(int[][] map,int[][] visited,int curx,int cury,int sum) {
		
		visited[cury][curx]=sum;
		if(N-1==curx&&N-1==cury&&sum<result)result=sum;
		
		for(int i=0;i<4;i++) {
			int nextx=dx[i]+curx;
			int nexty=dy[i]+cury;
			if(nextx>=0&&nexty>=0&&nextx<N&&nexty<N) {
				if(visited[nexty][nextx]>sum+map[nexty][nextx]) {
					dfs(map,visited,nextx,nexty,sum+map[nexty][nextx]);
				}	
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			N=Integer.parseInt(br.readLine());
			result=Integer.MAX_VALUE;
			int[][] map=new int[N][N];
			for(int i=0;i<N;i++) {
				String s=br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j]=s.charAt(j)-'0';
				}
			}
			
			int[][] visited=new int[N][N];
			
			for(int i=0;i<N;i++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
			dfs(map,visited,0,0,0);
			System.out.println("#"+(a+1)+" "+result);
		}
	}

}
