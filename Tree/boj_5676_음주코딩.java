package com.thread;
import java.io.*;
import java.util.*;

public class boj_5676_음주코딩 {

	static int[] tree, input;
	
	public static int init(int start,int end,int place) {
		
		if(start==end)return tree[place]=input[start];
		int mid=(start+end)/2;
		return tree[place]=init(start,mid,place*2)*init(mid+1,end,place*2+1);
	}
	
	public static int change(int start,int end,int place,int index,int value) {
		
		if(start>index||end<index)return tree[place];
		if(start==end) return tree[place]=value;
	
		int mid=(start+end)/2;
		return tree[place]=change(start,mid,place*2,index,value)*change(mid+1,end,place*2+1,index,value);
	
	}
	
	
	public static int multiply(int start,int end,int place,int pi,int pj) {
		
		if(pi>end||pj<start)return 1;
		if(pi<=start&&end<=pj)return tree[place];
		int mid=(start+end)/2;
		return multiply(start,mid,place*2,pi,pj)*multiply(mid+1,end,place*2+1,pi,pj);
	}
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			input=new int[N+1];
			int height=(int) Math.ceil(Math.log10(N+1)/Math.log10(2));
			int size=(int) Math.pow(2, height+1);
			tree=new int[size];
			
			for(int i=1;i<=N;i++) {
				int num=Integer.parseInt(st.nextToken());
				if(num>0)num=1;
				else if(num<0)num=-1;
				input[i]=num;
			}
			init(1,N,1);
			
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				char order=st.nextToken().charAt(0);
				if(order=='C') {
					int ci=Integer.parseInt(st.nextToken());
					int cv=Integer.parseInt(st.nextToken());
					if(cv<0)cv=-1;
					else if(cv>0)cv=1;
					change(1,N,1,ci,cv);
				}
				else if(order=='P') {
					int pi=Integer.parseInt(st.nextToken());
					int pj=Integer.parseInt(st.nextToken());
					int tmp=multiply(1,N,1,pi,pj);
					if(tmp==0)System.out.print(0);
					else if(tmp>0)System.out.print('+');
					else System.out.print('-');
				}
			}
			System.out.println();
		}
	}

}
