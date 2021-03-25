package algorithm.dp;
import java.util.*;
import java.io.*;

추public class boj_1012_유기농배추 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			int[][] map=new int[N][M];
			Queue<Integer[]> lettuceQ=new LinkedList<>();

			boolean[][] visited=new boolean[N][M];
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				int X=Integer.parseInt(st.nextToken());
				int Y=Integer.parseInt(st.nextToken());
				map[Y][X]=1;
				lettuceQ.add(new Integer[] {Y,X});
			}
			
			int worm=0;
			int[] dx= {0,0,-1,1};
			int[] dy= {-1,1,0,0};
			Queue<Integer[]> queue=new LinkedList<>();
			queue.add(lettuceQ.poll());
			
			while(!lettuceQ.isEmpty()||!queue.isEmpty()) {
				if(queue.isEmpty())queue.add(lettuceQ.poll());
				Integer[] cur=queue.poll();
				int x=cur[1];
				int y=cur[0];
				if(!visited[y][x])worm++;
				visited[y][x]=true;
				for(int i=0;i<4;i++) {
					int nextx=x+dx[i];
					int nexty=y+dy[i];
					if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&!visited[nexty][nextx]&&map[nexty][nextx]==1) {
						queue.add(new Integer[] {nexty,nextx});
						visited[nexty][nextx]=true;
					}
				}
			}
			
			System.out.println(worm);
		}
	}
}
