package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_4963_섬의개수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			if(w==0&&h==0)break;
			int[][] map=new int[h][w];
			ArrayList<Integer[]> land=new ArrayList<>();
			for(int i=0;i<h;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					int tmp=Integer.parseInt(st.nextToken());
					map[i][j]=tmp;
					if(tmp==1)land.add(new Integer[] {i,j});
				}
			}
			
			boolean[][] visited=new boolean[h][w];
			int[][] d= {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
			int count=0;
			for(int i=0;i<land.size();i++) {
				Integer[] cur=land.get(i);
				int curx=cur[1];
				int cury=cur[0];
				if(visited[cury][curx])continue;
				count++;
				Queue<Integer[]> queue=new LinkedList<>();
				queue.add(cur);
				visited[cury][curx]=true;
				while(!queue.isEmpty()) {
					Integer[] now=queue.poll();
					int nowx=now[1];
					int nowy=now[0];
					for(int j=0;j<8;j++) {
						int nextx=nowx+d[j][1];
						int nexty=nowy+d[j][0];
						if(nextx>=0&&nexty>=0&&nextx<w&&nexty<h&&!visited[nexty][nextx]&&map[nexty][nextx]==1) {
							visited[nexty][nextx]=true;
							queue.add(new Integer[] {nexty,nextx});
						}
					}
				}
			}
			
			System.out.println(count);
		}
	}

}
