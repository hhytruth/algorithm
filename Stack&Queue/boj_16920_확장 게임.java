package algorithm.stack;
import java.util.*;
import java.io.*;

public class boj_16920 {
	static class Pair{
		int first, second;
		public Pair(int i, int j) {
			this.first = i;
			this.second = j;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] Sarr=new int[P];
		int[] result=new int[P];
		for(int i=0;i<P;i++) {
			int S=Integer.parseInt(st.nextToken());
			if(S>1000000)S=1000000;
			Sarr[i]=S;
		}
		
		char[][] map=new char[N][M];
		LinkedList<Pair>[] queueList=new LinkedList[P];
		for(int i=0;i<P;i++) {
			queueList[i]=new LinkedList<Pair>();
		}
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]>='1'&&map[i][j]<='9') {
					result[map[i][j]-1-'0']++;
					queueList[map[i][j]-'0'-1].add(new Pair(i,j));
				}
			}
		}
		
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		while(true) {
			for(int a=0;a<P;a++) {
				if(queueList[a].isEmpty())continue;
				int repeat=0;
				while(!queueList[a].isEmpty()) {
					int size=queueList[a].size();
					while(size>0) {
						Pair p=queueList[a].poll();
						int player=map[p.first][p.second]-'0';
						for(int i=0;i<4;i++) {
							int curx=p.second+dx[i];	
							int cury=p.first+dy[i];
							if(curx>=0&&cury>=0&&curx<M&&cury<N) {
								if(map[cury][curx]=='.') {
									map[cury][curx]=(char)(player+'0');
									result[player-1]++;
									queueList[a].add(new Pair(cury,curx));
								}
							}
							
						}
						size--;
					}
					repeat++;
					if(repeat==Sarr[a])break;
					
					
				}
			
			}
			boolean ok = true;
			for(int i=0; i<P; i++) {
				if(queueList[i].size() > 0) ok = false;
			}
			if(ok) break;
	
			
			
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<P;i++) {
			sb.append(result[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
