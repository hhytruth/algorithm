package atest;
import java.io.*;
import java.util.*;

public class boj_20056_마법사상어와파이어볼 {

	public static class Fireball{
		int m;
		int s;
		int d;
		Fireball(int m,int s,int d){
			this.m=m;
			this.s=s;
			this.d=d;
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Queue<Fireball> map[][]=new LinkedList[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=new LinkedList<>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			map[r-1][c-1].add(new Fireball(m,s,d));
		}
		
		int[] dx= {0,1,1,1,0,-1,-1,-1};
		int[] dy= {-1,-1,0,1,1,1,0,-1};
		for(int a=0;a<K;a++) {
			Queue<Fireball> map2[][]=new LinkedList[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map2[i][j]=new LinkedList<>();
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					while(!map[i][j].isEmpty()) {
						Fireball ball=map[i][j].poll();
						int d=ball.d;
						int s=ball.s;
						int nx=(j+dx[d]*s)%N;
						if(nx<0)nx+=N;
						int ny=(i+dy[d]*s)%N;
						if(ny<0)ny+=N;
						map2[ny][nx].add(new Fireball(ball.m,s,d));
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map2[i][j].size()==1) map[i][j].add(map2[i][j].poll());
					else if(map2[i][j].isEmpty())continue;
					else {
						int even=0,odd=0,mass=0,speed=0,count=0;
						count=map2[i][j].size();
						while(!map2[i][j].isEmpty()) {
							Fireball ball=map2[i][j].poll();
							if(ball.d%2==0)even++;
							else odd++;
							mass+=ball.m;
							speed+=ball.s;
						}
						mass/=5;
						if(mass==0)continue;
						speed/=count;
						if(even==0||odd==0) {
							map[i][j].add(new Fireball(mass,speed,0));
							map[i][j].add(new Fireball(mass,speed,2));
							map[i][j].add(new Fireball(mass,speed,4));
							map[i][j].add(new Fireball(mass,speed,6));
						}
						else {
							map[i][j].add(new Fireball(mass,speed,1));
							map[i][j].add(new Fireball(mass,speed,3));
							map[i][j].add(new Fireball(mass,speed,5));
							map[i][j].add(new Fireball(mass,speed,7));
						}
						
					}
					
				}
			}
		}
		
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				while(!map[i][j].isEmpty()) {
					sum+=map[i][j].poll().m;
				}
			}
		}
		
		System.out.println(sum);
		
	}

}
