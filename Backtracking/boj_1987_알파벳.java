package com.inner;
import java.util.*;
import java.io.*;

public class boj_1987_알파벳 {

	static char[][] map;
	static int max=0;
	static int R,C;
	
	public static void go(int x,int y,int cnt,String reached) {
		
		if(x+1<C&&!reached.contains(Character.toString(map[y][x+1]))) {
			reached+=map[y][x+1];
			go(x+1,y,cnt+1,reached);
			reached=reached.substring(0, reached.length()-1);
		}
		if(y+1<R&&!reached.contains(Character.toString(map[y+1][x]))) {
			reached+=map[y+1][x];
			go(x,y+1,cnt+1,reached);
			reached=reached.substring(0,reached.length()-1);
		}
		if(x-1>=0&&!reached.contains(Character.toString(map[y][x-1]))) {
			reached+=map[y][x-1];
			go(x-1,y,cnt+1,reached);
			reached=reached.substring(0,reached.length()-1);
		}
		if(y-1>=0&&!reached.contains(Character.toString(map[y-1][x]))) {
			reached+=map[y-1][x];
			go(x,y-1,cnt+1,reached);
			reached=reached.substring(0,reached.length()-1);
		}
		if(max<cnt)max=cnt;
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		for(int a=0;a<R;a++) {
			String s=br.readLine();
			for(int b=0;b<C;b++) {
				map[a][b]=s.charAt(b);
			}
		}
		String reached=Character.toString(map[0][0]);
		go(0,0,1,reached);
		System.out.println(max);
		
	}

}
