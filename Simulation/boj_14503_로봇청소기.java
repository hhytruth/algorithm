package line2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14503_로봇청소기 {

	static boolean[][] visited;
	static int[][] map;
	static int count=0;
	static int[] nextdir= {3,0,1,2};
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int N,M;
	static int[] backx= {0,-1,0,1};
	static int[] backy= {1,0,-1,0};
	
	public static void dfs(int x,int y,int d) {
		
		if(!visited[y][x])count++;
		visited[y][x]=true;
		int nextx=x+dx[d];
		int nexty=y+dy[d];
		
		if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&!visited[nexty][nextx]&&map[nexty][nextx]==0) {
			dfs(nextx,nexty,nextdir[d]);
			return;
		}
		
		int tmpd=d;
		for(int i=0;i<4;i++) {
			nextx=x+dx[tmpd];
			nexty=y+dy[tmpd];
			if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&!visited[nexty][nextx]&&map[nexty][nextx]==0) {
				dfs(nextx,nexty,nextdir[tmpd]);
				return;
			}
			tmpd=nextdir[tmpd];

		}
		
		nextx=x+backx[d];
		nexty=y+backy[d];
		if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&map[nexty][nextx]==0) {
			dfs(nextx,nexty,d);
			return;
		}
		else return;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visited=new boolean[N][M];
		
		dfs(c,r,d);
		
		System.out.println(count);
	}

}
