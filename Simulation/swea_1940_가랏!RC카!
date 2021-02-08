package com.inner;
import java.io.*;
import java.util.*;

public class RCCar {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int distance=0;
			int totalSpeed=0;
			int N=Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int command=Integer.parseInt(st.nextToken());
				int speed;
				
				switch(command) {
				case 1:
					speed=Integer.parseInt(st.nextToken());
					totalSpeed+=speed;
					distance+=totalSpeed;
					break;
				case 2:
					speed=Integer.parseInt(st.nextToken());
					totalSpeed-=speed;
					if(totalSpeed<0)totalSpeed=0;
					distance+=totalSpeed;
					break;
				case 0:
					distance+=totalSpeed;
					break;
				}
				
			}
			System.out.println("#"+(a+1)+" "+distance);

		}

		
	}
	
}
