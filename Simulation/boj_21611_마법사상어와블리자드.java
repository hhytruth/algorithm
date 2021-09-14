package atest;
import java.util.*;
import java.io.*;

public class boj_21611_마법사상어와블리자드 {
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[] balls=new int[N*N];
		int x=N/2;
		int y=N/2;
		int idx=1;
		int direction=0,count=1;
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};
		balls[0]=-2;
		while(!(x==0&&y==0)) {
			for(int i=0;i<idx;i++) {
				x+=dx[direction];
				y+=dy[direction];
				balls[count++]=map[y][x];
				if(x==0&&y==0)break;
			}
			if(direction==1)idx++;
			else if(direction==3) {
				idx++;
				direction=-1;
			}
			direction++;
		}
		
		int explode1=0,explode2=0,explode3=0;
		int[] destroyDir= {7,3,1,5};
		for(int a=0;a<M;a++) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			
			int init=0;
			for(int i=0;i<s;i++) {
				balls[init+i*8+destroyDir[d-1]]=0;
				init+=i*8+destroyDir[d-1];
			}
			
			int[] tmp=new int[balls.length];
			int b=0;
			for(int i=0;i<balls.length;i++) {
				if(balls[i]!=0)tmp[b++]=balls[i];
			}
			balls=Arrays.copyOf(tmp, tmp.length);
			
			boolean change=false;
			while(true) {
				change=false;
				int index=0,cnt=0,previous=-1;
				for(int i=0;i<balls.length;i++) {
					int n=balls[i];
					if(n==previous) cnt++;
					else {
						index=i;
						if(cnt>=4) {
							if(previous==1)explode1+=cnt;
							else if(previous==2)explode2+=cnt;
							else if(previous==3) explode3+=cnt;
							change=true;
							for(int j=0;j<cnt;j++) {
								balls[i-j-1]=0;
							}
						}
						cnt=1;
						previous=n;

					}
				}
				
				tmp=new int[balls.length];
				b=0;
				for(int i=0;i<balls.length;i++) {
					if(balls[i]!=0)tmp[b++]=balls[i];
				}
				balls=Arrays.copyOf(tmp, tmp.length);
				
				if(!change)break;
			}
			
			int[] result=new int[N*N];
			result[0]=-2;
			int temp=1;
			int cnt=1,previous=-1;
			for(int i=1;i<balls.length;i++) {
				int n=balls[i];
				if(n==previous) cnt++;
				else {
					if(previous!=-1)result[temp++]=cnt;
					if(temp>=balls.length)break;
					if(previous>0)result[temp++]=previous;
					if(temp>=balls.length)break;
					previous=n;
					cnt=1;
				}
			}
			
			balls=Arrays.copyOf(result, balls.length);
		}
		
		System.out.println(1*explode1+2*explode2+3*explode3);
	}

}
