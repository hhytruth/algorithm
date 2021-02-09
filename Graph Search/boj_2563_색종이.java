package com.ssafy.algo;
import java.util.*;
import java.io.*;

public class Paper {

	public static void main(String args[])throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		boolean[][] map=new boolean[100][100];
		int count=0;
		for(int a=0;a<N;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int leftDist=Integer.parseInt(st.nextToken());
			int downDist=Integer.parseInt(st.nextToken());
			int startx=leftDist;
			int starty=100-downDist-10;
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					if(map[starty+i][startx+j]==false) {
						map[starty+i][startx+j]=true;
						count++;
					}
				}
			}
		}
		System.out.println(count);
		
	}
}
