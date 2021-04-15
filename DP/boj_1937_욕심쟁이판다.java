package com.thread;
import java.io.*;
import java.util.*;

public class boj_1937_욕심쟁이판다 {

	static int max=1;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int n;
	static int[][] visitCount, map;
	
	public static int dfs(int cury,int curx) {
		
		if(visitCount[cury][curx]!=0)return visitCount[cury][curx];
		visitCount[cury][curx]=1;
	//	visited[cury][curx]=true;
		
		for(int i=0;i<4;i++) {
			int nextx=curx+dx[i];
			int nexty=cury+dy[i];
			if(nextx>=0&&nexty>=0&&nextx<n&&nexty<n&&map[nexty][nextx]>map[cury][curx]) {
				int tmp=dfs(nexty,nextx)+1;
				visitCount[cury][curx]=Math.max(visitCount[cury][curx], tmp);
				if(tmp>max)max=tmp;
			}
		}
		return visitCount[cury][curx];
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		visitCount=new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visitCount[i][j]==0) dfs(i,j);
			}
		}
		
		System.out.println(max);
	}

}
