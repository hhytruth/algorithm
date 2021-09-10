package atest;
import java.io.*;
import java.util.*;

public class boj_21608_상어초등학교 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		ArrayList<Integer>[] favorites=new ArrayList[N*N];
		for(int i=0;i<N*N;i++) {
			favorites[i]=new ArrayList<>();
		}
		int[] students=new int[N*N];
		
		for(int i=0;i<N*N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int stu=Integer.parseInt(st.nextToken());
			students[i]=stu;
			for(int j=0;j<4;j++) {
				favorites[stu-1].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int[] dx= {0,1,0,-1};
		int[] dy= {-1,0,1,0};
		int sum=0;
		for(int i=0;i<N*N;i++) {
			int student=students[i];
			int maxlike=-1,x=-1,y=-1,maxempty=-1;
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					int likecnt=0,emptycnt=0;
					if(map[a][b]!=0)continue;
					for(int j=0;j<4;j++) {
						int nx=dx[j]+b;
						int ny=dy[j]+a;
						if(nx>=0&&ny>=0&&nx<N&&ny<N) {
							if(map[ny][nx]==0)emptycnt++;
							else if(favorites[student-1].contains(map[ny][nx]))likecnt++;
						}
					}
					if(maxlike<likecnt) {
						maxlike=likecnt;
						x=b;
						y=a;
						maxempty=emptycnt;
					}
					else if(maxlike==likecnt&&emptycnt>maxempty){
						maxempty=emptycnt;
						x=b;
						y=a;
					}
				}
			}
			map[y][x]=student;
			
		}
		
		for(int j=0;j<N;j++) {
			for(int k=0;k<N;k++) {
				int stu=map[j][k];
				int count=0;
				for(int a=0;a<4;a++) {
					int nx=dx[a]+k;
					int ny=dy[a]+j;
					if(nx>=0&&ny>=0&&nx<N&&ny<N) {
						int ns=map[ny][nx];
						if(favorites[stu-1].contains(ns))count++;
					}
				}
				if(count==1)sum++;
				else if(count==2)sum+=10;
				else if(count==3)sum+=100;
				else if(count==4)sum+=1000;
			}
		}
		
		System.out.println(sum);
		
	}

}
