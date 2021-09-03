package atest;
import java.io.*;
import java.util.*;

public class boj_21610_마법사상어와비바라기 {

	public static void main(String[] args) throws Exception {

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
		
		Queue<Integer[]> clouds=new LinkedList<>();	//1단계 전 구름 좌표 리스트
		clouds.add(new Integer[] {N-2,1});
		clouds.add(new Integer[] {N-2,0});
		clouds.add(new Integer[] {N-1,0});
		clouds.add(new Integer[] {N-1,1});
		Queue<Integer[]> clouds2=new LinkedList<>();	//1단계 후 구름 좌표 리스트
		int[] dx= {-1,-1,0,1,1,1,0,-1};	//8방향에 따른 좌표
		int[] dy= {0,-1,-1,-1,0,1,1,1};
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			clouds2.clear();
			boolean[][] visited=new boolean[N][N];
			while(!clouds.isEmpty()) {
				Integer[] cloud=clouds.poll();
				int nx=(cloud[1]+dx[d-1]*s)%N;	//N과 1이 이어져 있기 때문에 N으로 모듈로 연산
				int ny=(cloud[0]+dy[d-1]*s)%N;
				if(nx<0)nx+=N;	//음수일 때는 +N
				if(ny<0)ny+=N;
				clouds2.add(new Integer[] {ny,nx});
			}
			
			for(Integer[] cloud:clouds2) {	//2단계
				map[cloud[0]][cloud[1]]++;
				visited[cloud[0]][cloud[1]]=true;
			}
			
			int dx2[]= {-1,1,1,-1};	
			int dy2[]= {-1,-1,1,1};
			int[][] map2=new int[N][N];
			for(int a=0;a<N;a++) {	//물복사버그 마법 후 상태를 저장할 배열
				for(int b=0;b<N;b++) {
					map2[a][b]=map[a][b];
				}
			}
			
			for(Integer[] cloud:clouds2) {
				int x=cloud[1];
				int y=cloud[0];
				for(int j=0;j<4;j++) {	//대각선 4방 탐색 후 증가
					int nx=x+dx2[j];
					int ny=y+dy2[j];
					if(nx>=0&&nx<N&&ny>=0&&ny<N&&map[ny][nx]>0) map2[y][x]++;
				}
			}
			
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(map2[a][b]>=2) {	//5단계: 2 이상인 칸의 경우
						if(!visited[a][b]) {	//구름의 위치가 아니었던 경우 구름 만들기
							clouds.add(new Integer[] {a,b});
							map[a][b]=map2[a][b]-2;

						}
						else {	//구름의 위치였던 경우 map의 값을 그대로 반영
							map[a][b]=map2[a][b];
						}
					}
					else map[a][b]=map2[a][b];	//2 미만의 물이 있는 경우 map의 값을 그대로 반영
				}
			}			
			clouds2.clear();	//초기화
		}
	
		
		int result=0;
		for(int i=0;i<N;i++) {	//모든 바구니의 있는 물 합산
			for(int j=0;j<N;j++) {
				result+=map[i][j];
			}
		}
		
		System.out.println(result);
		
	}

}
