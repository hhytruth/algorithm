package com.thread;
import java.util.*;
import java.io.*;

public class jungol_1863_종교 {
	
	static int[] parent;
	
	public static int findSet(int x) {
		if(parent[x]==x)return x;
		else return parent[x]=findSet(parent[x]);
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		parent=new int[n+1];
		for(int a=1;a<=n;a++) {
			parent[a]=a;
		}
		for(int a=0;a<m;a++) {
			st=new StringTokenizer(br.readLine());
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			
			if(findSet(i)!=findSet(j)) {
				parent[findSet(j)]=findSet(i);
			}
		}
		
		int religion=0;
		for(int a=1;a<=n;a++) {
			if(parent[a]==a)religion++;
		}
		
		System.out.println(religion);
	}
	
}
