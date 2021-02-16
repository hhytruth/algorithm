package com.inner;
import java.util.*;
import java.io.*;

public class MP3Player {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int L=Integer.parseInt(br.readLine());
		int N=Integer.parseInt(br.readLine());
		int[] rollcake=new int[L+1];
		int maxExpectation=-1;
		int maxGet=-1;
		int maxExPerson=-1;
		int maxGetPerson=-1;
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int P=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			if(K-P>maxExpectation) {
				maxExPerson=i+1;
				maxExpectation=K-P;
			}
			int piece=0;
			for(int j=P;j<=K;j++) {
				if(rollcake[j]==0) {
					rollcake[j]=i+1;
					piece++;
				}
			}
			if(piece>maxGet) {
				maxGet=piece;
				maxGetPerson=i+1;
			}
			
		}
		System.out.println(maxExPerson);
		System.out.println(maxGetPerson);
	}

}
