package com.exception;
import java.io.*;
import java.util.*;

class Burger{
	int taste;
	int calorie;
	Burger(int t,int c){
		taste=t;
		calorie=c;
	}
}



public class Hamburger {
	static boolean[] used;
	static int N,L;
	static int max;
	static Burger[] burgers;
	static void make(int totalTaste,int totalCalorie,int N,int idx) {
		if(idx>=N) {
			if(totalCalorie<=L&&totalTaste>max) {
				max=totalTaste;
				return;
			}
		}
		else {
			used[idx]=false;
			make(totalTaste,totalCalorie,N,idx+1);
			
			used[idx]=true;
			make(totalTaste+burgers[idx].taste,totalCalorie+burgers[idx].calorie,N,idx+1);
		
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int a=0;a<TC;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			burgers=new Burger[N];
			used=new boolean[N];
			max=0;
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				int T=Integer.parseInt(st.nextToken());
				int K=Integer.parseInt(st.nextToken());
				Burger burger=new Burger(T,K);
				burgers[i]=burger;
			}
			
			make(0,0,N,0);
			System.out.println("#"+(a+1)+" "+max);
		}
		
	
	}
	

}
