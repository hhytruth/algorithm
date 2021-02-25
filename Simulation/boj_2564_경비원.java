package com.thread;
import java.util.*;
import java.io.*;

public class boj_2564_경비원 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int width=Integer.parseInt(st.nextToken());
		int height=Integer.parseInt(st.nextToken());
		int count=Integer.parseInt(br.readLine());
		int[][] markets=new int[count][2];
		int dgx=0,dgy=0;
		for(int a=0;a<=count;a++) {
			st=new StringTokenizer(br.readLine());
			int direction=Integer.parseInt(st.nextToken());
			int distance=Integer.parseInt(st.nextToken());
			int x=0,y=0;
			switch(direction) {
			case 1:
				y=0;
				x=distance;
				break;
			case 2:
				y=height;
				x=distance;
				break;
			case 3:
				x=0;
				y=distance;
				break;
			case 4:
				x=width;
				y=distance;
				break;
			}
			int[] place= {x,y};
			if(a==count) {
				dgx=x;
				dgy=y;
			}
			else markets[a]=place;
		}	
		
		int sum=0;
		for(int i=0;i<count;i++) {
			int curx=dgx;
			int cury=dgy;
			int clock=0,counter=0;
			while(true) {
				if(cury==0&&curx<width)curx++;
				else if(curx==width&&cury<height)cury++;
				else if(cury==height&&curx>0)curx--;
				else cury--;
				clock++;
				if(markets[i][0]==curx&&markets[i][1]==cury)break;
			}
			counter=2*width+2*height-clock;
			sum+=Math.min(clock, counter);
		}
		System.out.println(sum);
	}
	
	

}
