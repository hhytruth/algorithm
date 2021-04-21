package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_2146_다리만들기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		ArrayList<Integer[]> lands=new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				map[i][j]=tmp;
				if(tmp==1) lands.add(new Integer[] {i,j});
			}
		}
		
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		int count=1;
		boolean[][] visited=new boolean[N][N];


		for(int i=0;i<lands.size();i++) {
			
			Queue<Integer[]> queue=new LinkedList<>();
			Integer[] land=lands.get(i);
			int landx=land[1];
			int landy=land[0];
			if(visited[landy][landx])continue;
			visited[landy][landx]=true;
			queue.add(land);
			while(!queue.isEmpty()) {
				Integer[] cur=queue.poll();
				int curx=cur[1];
				int cury=cur[0];
				map[cury][curx]=count;
				for(int j=0;j<4;j++) {
					int nextx=curx+dx[j];
					int nexty=cury+dy[j];
					if(nextx>=0&&nexty>=0&&nextx<N&&nexty<N&&!visited[nexty][nextx]&&map[nexty][nextx]==1) {
						queue.add(new Integer[] {nexty,nextx});
						visited[nexty][nextx]=true;
					}
				}
			}
			count++;
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<lands.size();i++) {
			
			Queue<Integer[]> queue=new LinkedList<>();
			Integer[] land=lands.get(i);
			boolean[][] visited2=new boolean[N][N];
			int landx=land[1];
			int landy=land[0];
			int landnum=map[landy][landx];
			visited2[landy][landx]=true;
			queue.add(land);
			int size=1,size2=0;
			int length=0;
			while(!queue.isEmpty()) {
				for(int a=0;a<size;a++) {
					Integer[] cur=queue.poll();
					int curx=cur[1];
					int cury=cur[0];
					for(int j=0;j<4;j++) {
						int nextx=curx+dx[j];
						int nexty=cury+dy[j];
						if(nextx>=0&&nexty>=0&&nextx<N&&nexty<N&&!visited2[nexty][nextx]) {
							if(map[nexty][nextx]!=0&&map[nexty][nextx]!=landnum) {
								if(min>length)min=length;
								size=0;
								queue.clear();
								break;
							}
							queue.add(new Integer[] {nexty,nextx});
							visited2[nexty][nextx]=true;
							size2++;
						}
					}
				}
				size=size2;
				size2=0;
				length++;
			}
		}
		
		System.out.println(min);
	}

}
