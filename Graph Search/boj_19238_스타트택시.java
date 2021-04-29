package line;
import java.io.*;
import java.util.*;

public class boj_19238_스타트택시 {
	
	static class Node implements Comparable<Node>{
		
		int x,y,count;
		
		Node(int x,int y,int count){
			this.x=x;
			this.y=y;
			this.count=count;
		}

		@Override
		public int compareTo(Node o) {
			if(this.count!=o.count)return this.count-o.count;
			else if(this.y!=o.y)return this.y-o.y;
			else return this.x-o.x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int oil=Integer.parseInt(st.nextToken());
		int[][] map=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		int[][] goals=new int[M+1][2];
		boolean[] tooktaxi=new boolean[M+1];
		int starty=Integer.parseInt(st.nextToken());
		int startx=Integer.parseInt(st.nextToken());
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			int srcy=Integer.parseInt(st.nextToken());
			int srcx=Integer.parseInt(st.nextToken());
			goals[i][0]=Integer.parseInt(st.nextToken());
			goals[i][1]=Integer.parseInt(st.nextToken());
			map[srcy][srcx]=i*-1;
		}
		
		int custleft=M;
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		
		for(int i=0;i<M;i++) {
			int[] dist=new int[M];
			Arrays.fill(dist, 401);
			PriorityQueue<Node> pq=new PriorityQueue<>();
			boolean[][] visited=new boolean[N+1][N+1];
			visited[starty][startx]=true;
			pq.add(new Node(startx,starty,0));
			int customer=0,oiluse=0;
			int count=1,count2=0;
			boolean found=false;
			
			while(!pq.isEmpty()) {
				for(int k=0;k<count;k++) {
					Node cur=pq.poll();
					int curx=cur.x;
					int cury=cur.y;
					if(map[cury][curx]<0&&!tooktaxi[map[cury][curx]*-1]) {
						customer=map[cury][curx]*-1;
						pq.clear();
						starty=cury;
						startx=curx;
						found=true;
						break;
					}
					for(int j=0;j<4;j++) {
						int nextx=curx+dx[j];
						int nexty=cury+dy[j];
						if(nextx>0&&nexty>0&&nextx<=N&&nexty<=N&&!visited[nexty][nextx]&&map[nexty][nextx]!=1) {
							int tmp=map[nexty][nextx]*-1;
						
							visited[nexty][nextx]=true;
							pq.add(new Node(nextx,nexty,oiluse+1));
							count2++;
						
						}
					}
					if(found)break;
				}
				oiluse++;
				count=count2;
				count2=0;
			}
			
			oiluse--;
			
			Queue<Integer[]> queue=new LinkedList<>();
			tooktaxi[customer]=true;
			queue.add(new Integer[] {starty,startx});
			visited=new boolean[N+1][N+1];
			visited[starty][startx]=true;
			count=1;
			count2=0;
			boolean found2=false;
			int withCustomer=0;
			int goalx=goals[customer][1];
			int goaly=goals[customer][0];
			
			while(!queue.isEmpty()) {		
				for(int k=0;k<count;k++) {
					Integer[] cur=queue.poll();
					int curx=cur[1];
					int cury=cur[0];
					for(int j=0;j<4;j++) {
						int nextx=curx+dx[j];
						int nexty=cury+dy[j];
						if(nextx>0&&nexty>0&&nextx<=N&&nexty<=N&&!visited[nexty][nextx]&&map[nexty][nextx]!=1) {
							if(nexty==goaly&&nextx==goalx) {
								queue.clear();
								found2=true;
								break;
							}
							else {
								visited[nexty][nextx]=true;
								queue.add(new Integer[] {nexty,nextx});
								count2++;
							}
						}
					}
					if(found2)break;
				}
				withCustomer++;
				count=count2;
				count2=0;
			}
			
			if(!found||!found2||oiluse+withCustomer>oil) {
				System.out.println(-1);
				return;
			}
			oil-=oiluse-withCustomer;
			
			starty=goaly;
			startx=goalx;
			
		}
		
		System.out.println(oil);
		
	}
}
