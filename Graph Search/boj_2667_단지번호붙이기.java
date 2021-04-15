package com.thread;
import java.util.*;
import java.io.*;

public class boj_2667_단지번호붙이기 {

	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int N;
	static ArrayList<Integer> tenants;
	static int count;
	public static void dfs(char[][] map, boolean[][] visited,int curx,int cury) {
				
		visited[cury][curx]=true;
		count++;
		
		for(int i=0;i<4;i++) {
			int nextx=curx+dx[i];
			int nexty=cury+dy[i];
			if(nextx<0||nexty<0||nextx>=N||nexty>=N||visited[nexty][nextx]||map[nexty][nextx]=='0')continue;
			dfs(map,visited,nextx,nexty);
		}

	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		char[][] map=new char[N][N];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				char c=s.charAt(j);
				map[i][j]=c;
			}
		}
		
		
		boolean[][] visited=new boolean[N][N];
		tenants=new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				count=0;
				if(!visited[i][j]&&map[i][j]=='1') {
					dfs(map,visited,j,i);
					tenants.add(count);
				}
			}
		}
		
		Collections.sort(tenants);
		System.out.println(tenants.size());
		for(int i=0;i<tenants.size();i++) {
			System.out.println(tenants.get(i));
		}
	}

}
