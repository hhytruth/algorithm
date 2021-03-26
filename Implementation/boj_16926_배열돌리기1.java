package com.off.day4.sol;
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj_16926_배열돌리기 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int[][] map=new int[N][M];
		int[][] result=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int A=Integer.parseInt(st.nextToken());
				map[i][j]=A;
			}
		}
		
		for(int a=0;a<R;a++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					int levelx=Math.min(j, M-1-j);
					int levely=Math.min(i, N-1-i);
					int level=Math.min(levelx, levely);
					int destx=j,desty=i;
					if(j==level) {
						//좌변에 있는 수
						if(i==N-1-level) destx++;
						else desty++;
					}
					else if(i==N-1-level) {
						//하변
						if(j==M-1-level)desty--;
						else destx++;
					}
					else if(j==M-1-level) {
						//우변
						if(i==level)destx--;
						else desty--;
					}
					else if(i==level) {
						//상변
						if(j==level)desty++;
						else destx--;
					}
					result[desty][destx]=map[i][j];
					
					
				}
			}
			for(int x=0;x<N;x++) {
				for(int y=0;y<M;y++) {
					map[x][y]=result[x][y];
				}
			}
			
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
