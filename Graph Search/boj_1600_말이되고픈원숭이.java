package swing;
import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	int usedK;
	int move;
	Node(int x,int y,int usedK,int move){
		this.x=x;
		this.y=y;
		this.usedK=usedK;
		this.move=move;
	}
}

public class boj_1600_말이되고픈원숭이 {
	
	static int H,W;
	static int[] dx= {1,2,2,1,-1,-2,-2,-1,0,0,-1,1};
	static int[] dy= {-2,-1,1,2,2,1,-1,-2,-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		int[][] map=new int[H][W];
		
		for(int i=0;i<H;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Node> queue=new LinkedList<>();
		Node start=new Node(0,0,0,0);
		queue.add(start);
		boolean[][][] visited=new boolean[H][W][K+1];
		while(!queue.isEmpty()) {
			Node now=queue.poll();
			int x=now.x;
			int y=now.y;
			if(x==W-1&&y==H-1) {
				System.out.println(now.move);
				return;
			}
			
			if(now.usedK<K) {
				for(int i=0;i<8;i++) {
					int nextx=x+dx[i];
					int nexty=y+dy[i];
					if(nextx>=0&&nexty>=0&&nextx<W&&nexty<H&&map[nexty][nextx]==0&&!visited[nexty][nextx][now.usedK+1]) {
						Node node=new Node(nextx,nexty,now.usedK+1,now.move+1);
						visited[nexty][nextx][now.usedK+1]=true;
						queue.add(node);
						
					}
				}	
			}	
			
			for(int i=8;i<12;i++) {
				int nextx=x+dx[i];
				int nexty=y+dy[i];
				if(nextx>=0&&nexty>=0&&nextx<W&&nexty<H&&map[nexty][nextx]==0&&!visited[nexty][nextx][now.usedK]) {
					Node node=new Node(nextx,nexty,now.usedK,now.move+1);
					visited[nexty][nextx][now.usedK]=true;
					queue.add(node);
				}
			
			}
			
				
			
		}
		System.out.println(-1);
		
		
	}
}
