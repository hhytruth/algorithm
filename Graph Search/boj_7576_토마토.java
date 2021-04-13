package swing;
import java.util.*;
import java.io.*;

public class boj_7576_토마토 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int[][] map=new int[N][M];
		Queue<Integer[]> queue=new LinkedList<>();
		int remain=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tomato=Integer.parseInt(st.nextToken());
				map[i][j]=tomato;
				if(tomato==0)remain++;
				else if(tomato==1)queue.add(new Integer[] {i,j});
			}
		}
		
		if(remain==0) {
			queue.clear();
		}
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		boolean[][] visited=new boolean[N][M];
		int time=0, checkTime2=0;
		int checkTime=queue.size();
		while(!queue.isEmpty()) {
			boolean changed=false;
			for(int j=0;j<checkTime;j++) {
				Integer[] cur=queue.poll();
				int curx=cur[1];
				int cury=cur[0];
				visited[cury][curx]=true;
				
				for(int i=0;i<4;i++) {
					int nextx=dx[i]+curx;
					int nexty=dy[i]+cury;
					if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N) {
						if(!visited[nexty][nextx]&&map[nexty][nextx]==0) {
							map[nexty][nextx]=1;
							queue.add(new Integer[] {nexty,nextx});
							remain--;
							checkTime2++;
							changed=true;
						}
					}
					
				}
			}
			time++;
			checkTime=checkTime2;
			checkTime2=0;
			if(remain==0)break;
			if(!changed) {
				time--;
				break;
			}
		}
		
		if(remain>0)System.out.println(-1);
		else System.out.println(time);
		
		
	}

}
