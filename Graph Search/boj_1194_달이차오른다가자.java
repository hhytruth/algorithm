package swing;
import java.io.*;
import java.util.*;

public class boj_1194_달이차오른다가자 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] map=new char[N][M];
		int ysx=0,ysy=0;
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				char c=s.charAt(j);
				map[i][j]=c;
				if(c=='0') {
					ysx=j;
					ysy=i;
				}
			}
		}
		
		boolean[] keys=new boolean[6];
		int[][][] visited=new int[N][M][64];
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		Queue<Integer[]> queue=new LinkedList<>();
		queue.add(new Integer[] {ysy,ysx,0});
		int count=1,count2=0;
		int answer=1;
		while(!queue.isEmpty()) {
			for(int a=0;a<count;a++) {
				Integer[] cur=queue.poll();
				int cury=cur[0],curx=cur[1],curk=cur[2];
				
				for(int i=0;i<4;i++) {
					int nextx=curx+dx[i];
					int nexty=cury+dy[i];
					if(nextx>=0&&nexty>=0&&nextx<M&&nexty<N&&visited[nexty][nextx][curk]==0) {
						if(map[nexty][nextx]=='.'||map[nexty][nextx]=='0') {
							queue.add(new Integer[] {nexty,nextx,curk});
							count2++;
							visited[nexty][nextx][curk]=answer;
						}
						else if(map[nexty][nextx]>='a'&&map[nexty][nextx]<='f') {
							queue.add(new Integer[] {nexty,nextx,curk|(1<<(map[nexty][nextx]-'a'))});
							count2++;
							visited[nexty][nextx][curk]=answer;
						}
						else if(map[nexty][nextx]=='1') {
							System.out.println(answer);
							return;
						}
						else if(map[nexty][nextx]>='A'&&map[nexty][nextx]<='F') {
							int door=(1<<(map[nexty][nextx]-'A'));
							if((curk&(1<<(map[nexty][nextx]-'A')))==0)continue;
							queue.add(new Integer[] {nexty,nextx,curk});
							count2++;
							visited[nexty][nextx][curk]=answer;
						}
					}
				}	
			}
			
			count=count2;
			count2=0;
			answer++;
		}
		
		if(queue.isEmpty())System.out.println(-1);
	}

}
