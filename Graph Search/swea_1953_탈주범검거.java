package swing;

import java.util.*;
import java.io.*;

public class swea_1953_탈주범검거 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			int L=Integer.parseInt(st.nextToken());
			int[][] map=new int[N][M];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int count=0;
			int[] dx= {0,0,-1,1};
			int[] dy= {-1,1,0,0};
			Queue<Integer[]> queue=new LinkedList<>();
			queue.add(new Integer[] {R,C});
			int size=1;
			int size2=0;
			int time=0;
			boolean[][] visited=new boolean[N][M];
			while(!queue.isEmpty()) {
				if(time>=L)break;
				for(int j=0;j<size;j++) {
					Integer[] cur=queue.poll();
					count++;
					int curx=cur[1];
					int cury=cur[0];
					int pipe=map[cury][curx];
					int[] direction=null;
					switch(pipe) {
					case 1:
						direction= new int[] {0,1,2,3};
						break;
					case 2:
						direction=new int[] {0,1};
						break;
					case 3:
						direction=new int[] {2,3};
						break;
					case 4:
						direction=new int[] {0,3};
						break;
					case 5:
						direction=new int[] {1,3};
						break;
					case 6:
						direction=new int[] {1,2};
						break;
					case 7:
						direction=new int[] {0,2};
						break;
					}
					for(int i=0;i<direction.length;i++) {
						int nexty,nextx;
						switch(direction[i]){
						case 0:
							nextx=curx+dx[0];
							nexty=cury+dy[0];
							if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&!visited[nexty][nextx]) {
								int nextpipe=map[nexty][nextx];
								if(nextpipe==2||nextpipe==5||nextpipe==1||nextpipe==6) {
									visited[nexty][nextx]=true;
									queue.add(new Integer[] {nexty,nextx});
									size2++;
								}
							}
							break;
						case 1:
							nextx=curx+dx[1];
							nexty=cury+dy[1];
							if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&!visited[nexty][nextx]) {
								int nextpipe=map[nexty][nextx];
								if(nextpipe==1||nextpipe==2||nextpipe==4||nextpipe==7) {
									visited[nexty][nextx]=true;
									queue.add(new Integer[] {nexty,nextx});
									size2++;
								}
							}
							break;
						case 2:
							nextx=curx+dx[2];
							nexty=cury+dy[2];
							if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&!visited[nexty][nextx]) {
								int nextpipe=map[nexty][nextx];
								if(nextpipe==1||nextpipe==3||nextpipe==4||nextpipe==5) {
									visited[nexty][nextx]=true;
									queue.add(new Integer[] {nexty,nextx});
									size2++;
								}
							}
							break;
						case 3:
							nextx=curx+dx[3];
							nexty=cury+dy[3];
							if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&!visited[nexty][nextx]) {
								int nextpipe=map[nexty][nextx];
								if(nextpipe==1||nextpipe==3||nextpipe==6||nextpipe==7) {
									visited[nexty][nextx]=true;
									queue.add(new Integer[] {nexty,nextx});
									size2++;
								}
							}
							break;
						}
					}
				}
				size=size2;
				size2=0;
				time++;
			}
			
			if(L==1)count++;
			System.out.println(("#"+(a+1)+" "+(count-1)));
		}
		
	}

}
