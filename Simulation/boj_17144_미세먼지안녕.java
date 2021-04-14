package swing;

import java.util.*;
import java.io.*;

public class boj_17144_미세먼지안녕 {
	
	public static void main(String[] args) throws Exception{
				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int T=Integer.parseInt(st.nextToken());
		int[][] map=new int[R][C];
		int[][] result=new int[R][C];
		int[] cleanerUP = null;
		int[] cleanerDOWN=null;
		int total=0;
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				int A=Integer.parseInt(st.nextToken());
				map[i][j]=A;
				result[i][j]=A;
				if(A==-1) {
					if(cleanerUP==null) {
						cleanerUP=new int[] {i,j};
					}
					else cleanerDOWN=new int[] {i,j};
				}
				else if(A>0) total+=A;
			}
		}
		
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		for(int i=0;i<T;i++) {
			for(int k=0;k<R;k++) {
				for(int l=0;l<C;l++) {
					if(map[k][l]<=0)continue;
					int curx=l;
					int cury=k;
					int spread=map[cury][curx]/5;
					if(spread==0)continue;
					
					int spreadCount=0;
					for(int j=0;j<4;j++) {
						int nextx=curx+dx[j];
						int nexty=cury+dy[j];
						if(nextx>=0&&nexty>=0&&nextx<C&&nexty<R&&map[nexty][nextx]!=-1) {
							spreadCount++;
							result[nexty][nextx]+=spread;
							total+=spread;
						}
					}
					result[cury][curx]-=spreadCount*spread;
					total-=spreadCount*spread;
				}
				
			}
			
			for(int j=0;j<R;j++) {
				for(int k=0;k<C;k++) {
					map[j][k]=result[j][k];
				}
			}
			
			int upy=cleanerUP[0];
			int downy=cleanerDOWN[0];
			map[upy][1]=0;
			map[downy][1]=0;
			for(int j=1;j<C-1;j++) {
				map[upy][j+1]=result[upy][j];
				map[downy][j+1]=result[downy][j];
			}
			for(int j=1;j<=upy;j++) {
				map[upy-j][C-1]=result[upy-j+1][C-1];
			}
			for(int j=downy+1;j<R;j++) {
				map[j][C-1]=result[j-1][C-1];
			}
			for(int j=C-2;j>=0;j--) {
				map[0][j]=result[0][j+1];
				map[R-1][j]=result[R-1][j+1];
			}
			for(int j=1;j<upy;j++) {
				map[j][0]=result[j-1][0];
			}
			total-=result[upy-1][0];
			for(int j=R-2;j>downy;j--) {
				map[j][0]=result[j+1][0];
			}
			total-=result[downy+1][0];
			
			if(total<=0)break;
			for(int j=0;j<R;j++) {
				for(int k=0;k<C;k++) {
					result[j][k]=map[j][k];
				}
			}
		}
		
		System.out.println(total);
		
	}

}
