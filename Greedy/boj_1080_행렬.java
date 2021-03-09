package algorithm.greedy;
import java.io.*;
import java.util.*;

public class boj_1080_행렬 {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] matrixA=new int[N][M];
		int[][] matrixB=new int[N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				matrixA[i][j]=s.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				matrixB[i][j]=s.charAt(j);
			}
		}
		
		boolean[][] diff=new boolean[N][M];
		int diffCount=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(matrixA[i][j]!=matrixB[i][j]) {
					diff[i][j]=true;
					diffCount++;
				}
			}
		}
		
		int[] dxdy= {0,1,2};
		int count=0;
		boolean found=false;
		boolean[][] flipped=new boolean[N][M];

		
		for(int i=0;i<N-2;i++) {
			for(int j=0;j<M-2;j++) {
				if(diff[i][j]==true&&!flipped[i][j]) {
					
					for(int a=0;a<3;a++) {
						for(int b=0;b<3;b++) {
							diff[i+dxdy[a]][j+dxdy[b]]=!diff[i+dxdy[a]][j+dxdy[b]];
							if(diff[i+dxdy[a]][j+dxdy[b]]==true)diffCount++;
							else diffCount--;
						}
					}
					flipped[i][j]=true;
					count++;
				}
			}
		}
		
		if((N<3||M<3)&&diffCount>0)System.out.println(-1);
		else if(diffCount>0)System.out.println(-1);
		else System.out.println(count);
		
		
		
	}

}
