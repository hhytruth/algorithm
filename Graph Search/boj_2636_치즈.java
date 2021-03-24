package swing;
import java.io.*;
import java.util.*;


public class boj_2636_치즈 {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int height=Integer.parseInt(st.nextToken());
		int width=Integer.parseInt(st.nextToken());
		int[][] map=new int[height][width];
		int cheezeCount=0;
		
		for(int i=0;i<height;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<width;j++) {
				int cheeze=Integer.parseInt(st.nextToken());
				map[i][j]=cheeze;
				if(cheeze==1)cheezeCount++;
				if(cheeze==0)map[i][j]=2;
			}
		}
		
		int hour=0;
		int remain=cheezeCount;
		while(cheezeCount>0) {
			remain=cheezeCount;
			Queue<Integer[]> queue=new LinkedList<>();
			int[] dx= {0,0,-1,1};
			int[] dy= {-1,1,0,0};
			Integer[] start= {0,0};
			boolean[][] visited=new boolean[height][width];
			queue.add(start);
			while(!queue.isEmpty()) {
				Integer[] now=queue.poll();
				int y=now[0];
				int x=now[1];
				map[y][x]=0;
				for(int k=0;k<4;k++) {
					if(dx[k]+x>=0&&dx[k]+x<width&&dy[k]+y>=0&&dy[k]+y<height) {
						if(!visited[y+dy[k]][x+dx[k]]&&map[y+dy[k]][x+dx[k]]!=1) {
							Integer[] tmp= {y+dy[k],x+dx[k]};
							map[y+dy[k]][x+dx[k]]=0;
							visited[y+dy[k]][x+dx[k]]=true;
							queue.add(tmp);
						}
					}
				}	
			}
			
			
			
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(map[i][j]==1) {
						for(int k=0;k<4;k++) {
							if(dx[k]+j>=0&&dx[k]+j<width&&dy[k]+i>=0&&dy[k]+i<height) {
								if(map[i+dy[k]][j+dx[k]]==0) {
									map[i][j]=3;
									cheezeCount--;
									break;
								}
							}
						}	
					}
					
				}
			}
			
			hour++;
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(map[i][j]==3)map[i][j]=0;
				}
			}
		}
		
		System.out.println(hour);
		System.out.println(remain);
		
	}
}
