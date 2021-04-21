package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_2178_미로탐색 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] map=new char[N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		int[][] visited=new int[N][M];
		Queue<Integer[]> queue=new LinkedList<>();
		int[] dx= {0,0,-1,1,};
		int[] dy= {-1,1,0,0};
		queue.add(new Integer[] {0,0});
		visited[0][0]=1;
		while(!queue.isEmpty()) {
			Integer[] cur=queue.poll();
			int curx=cur[1];
			int cury=cur[0];
			for(int i=0;i<4;i++) {
				int nextx=curx+dx[i];
				int nexty=cury+dy[i];
				if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&visited[nexty][nextx]==0&&map[nexty][nextx]=='1') {
					queue.add(new Integer[] {nexty,nextx});
					visited[nexty][nextx]=visited[cury][curx]+1;
					if(nexty==N-1&&nextx==M-1) {
						System.out.println(visited[nexty][nextx]);
						return;
					}
				}
			}
		}
	}

}
