package swing;
import java.util.*;
import java.io.*;

public class swea_4014_활주로건설 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int X=Integer.parseInt(st.nextToken());
			int[][] map=new int[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int road=0;
			boolean[][] built=new boolean[N][N];
			for(int i=0;i<N;i++) {
				boolean buildOK=true;
				for(int j=0;j<N-1;j++) {
					int now=map[i][j];
					int next=map[i][j+1];
					if(now==next)continue;
					if(Math.abs(now-next)>1) {
						buildOK=false;
						break;
					}
					if(now-next==1) {
						if(j>=N-X) {
							buildOK=false;
							break;
						}
						for(int k=1;k<=X;k++) {
							if(map[i][j+k]!=next) {
								buildOK=false;
								break;
							}
							else if(built[i][j+k]) {
								buildOK=false;
								break;
							}
						}
						if(!buildOK)break;
						else {
							for(int k=1;k<=X;k++) {
								built[i][j+k]=true;
							}
							j+=X-1;
						}
					}
					else if(now-next==-1) {
						if(j+1-X<0) {
							buildOK=false;
							break;
						}
						for(int k=1;k<X;k++) {
							if(map[i][j-k]!=now) {
								buildOK=false;
								break;
							}
							else if(built[i][j-k]) {
								buildOK=false;
								break;
							}
						}
						if(!buildOK)break;
						else {
							for(int k=1;k<X;k++) {
								built[i][j-k]=true;
							}
						}
					}
					
				}
				if(buildOK)road++;
			}
			
			built=new boolean[N][N];
			for(int i=0;i<N;i++) {
				boolean buildOK=true;
				for(int j=0;j<N-1;j++) {
					int now=map[j][i];
					int next=map[j+1][i];
					if(now==next)continue;
					if(Math.abs(now-next)>1) {
						buildOK=false;
						break;
					}
					if(now-next==1) {
						if(j>=N-X) {
							buildOK=false;
							break;
						}
						for(int k=1;k<=X;k++) {
							if(map[j+k][i]!=next) {
								buildOK=false;
								break;
							}
							else if(built[j+k][i]) {
								buildOK=false;
								break;
							}
						}
						if(!buildOK)break;
						else {
							for(int k=1;k<=X;k++) {
								built[j+k][i]=true;
							}
							j+=X-1;
							
						}
					}
					else if(now-next==-1) {
						if(j+1-X<0) {
							buildOK=false;
							break;
						}
						for(int k=1;k<X;k++) {
							if(map[j-k][i]!=now) {
								buildOK=false;
								break;
							}
							else if(built[j-k][i]) {
								buildOK=false;
								break;
							}
						}
						if(!buildOK)break;
						else {
							for(int k=1;k<X;k++) {
								built[j-k][i]=true;
							}
						}
					}
				}
				if(buildOK)road++;
			}
			
			System.out.println("#"+(a+1)+" "+road);
		}
	}

}
