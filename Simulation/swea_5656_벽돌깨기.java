package swing;

import java.util.*;
import java.io.*;

public class swea_5656_벽돌깨기 {
	
	static int[][] map, map2,orig;
	static int N,H,W;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static Queue<Integer[]> queue=new LinkedList<>();
	static int[] top,topOrig;
	static boolean[][] visited;
	static Stack<Integer> stack;
	static int brickCount;
	static int max;
	
	public static void perm(int W,int N,int[] result,int count) {
		
		if(count==N) {
			boolean found=false;
			for(int i=0;i<W;i++) {
				top[i]=topOrig[i];
			}
			map2=new int[H][W];
			int remove=0;
			visited=new boolean[H][W];
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					map2[i][j]=orig[i][j];
					map[i][j]=orig[i][j];
				}
			}
			
			for(int i=0;i<N;i++) {
				int shootPlace=result[i];
				for(int j=0;j<H;j++) {
					for(int k=0;k<W;k++) {
						map2[j][k]=map[j][k];
					}
				}
				queue.clear();
				if(top[shootPlace]==H)return;
				visited=new boolean[H][W];
				queue.add(new Integer[] {top[shootPlace],shootPlace});
				remove++;
				while(!queue.isEmpty()) {
					if(brickCount<=remove||found) {
						max=brickCount;
						break;
					}
					Integer[] cur=queue.poll();
					int curx=cur[1];
					int cury=cur[0];
					int num=map[cury][curx];
					
					map2[cury][curx]=0;
					visited[cury][curx]=true;
				
					for(int j=0;j<4;j++) {
						for(int k=1;k<num;k++) {
							int nextx=curx+dx[j]*k;
							int nexty=cury+dy[j]*k;
							if(nextx<0||nexty<0||nextx>=W||nexty>=H)continue;
							if(map[nexty][nextx]==1&&!visited[nexty][nextx]) {
								map2[nexty][nextx]=0;
								visited[nexty][nextx]=true;
								remove++;
								if(brickCount<=remove) {
									found=true;
									break;
								}
							}
							else if(map[nexty][nextx]>1&&!visited[nexty][nextx]) {
								map2[nexty][nextx]=0;
								queue.add(new Integer[] {nexty,nextx});
								visited[nexty][nextx]=true;
								remove++;
								if(brickCount<=remove) {
									found=true;
									break;
								}
							}
						}
						if(found)break;
					}
					
					
				}
				
				for(int j=0;j<W;j++) {
					stack=new Stack<>();
					for(int k=0;k<H;k++) {
						if(map2[k][j]!=0)stack.push(map2[k][j]);
					}
					top[j]=H-stack.size();
					
					for(int k=0;k<H-stack.size();k++) {
						map[k][j]=0;
					}
					int size=stack.size();
					for(int k=H-1;k>=H-size;k--) {
						map[k][j]=stack.pop();
					}
					
					
				}
				
			}
			if(max<remove) {
				max=remove;
				
			}
			return;
		}
		for(int i=0;i<W;i++) {
			result[count]=i;
			perm(W,N,result,count+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			map=new int[H][W];
			orig=new int[H][W];
			topOrig=new int[W];
			top=new int[W];
			brickCount=0;
			max=0;
			for(int i=0;i<W;i++) {
				topOrig[i]=-1;
				top[i]=-1;
			}
			for(int i=0;i<H;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					int brick=Integer.parseInt(st.nextToken());
					orig[i][j]=brick;
					map[i][j]=brick;
					if(map[i][j]!=0&&topOrig[j]==-1) {
						top[j]=i;
						topOrig[j]=i;
					}
					if(brick>0)brickCount++;
				}
			}
			for(int i=0;i<W;i++) {
				if(topOrig[i]==-1) {
					top[i]=H;
					topOrig[i]=H;
				}
			}
			
			int[] result=new int[N];
			if(brickCount!=0) perm(W,N,result,0);
			
			System.out.println("#"+(a+1)+" "+(brickCount-max));
			
		}
		
	}

}
