package com.thread;
import java.util.*;
import java.io.*;

public class swea_3289_서로소집합 {
	
	static int[] parent;
	public static int findSet(int x) {
		if(x==parent[x])return x;
		else {
			return parent[x]=findSet(parent[x]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb;
		for(int x=0;x<T;x++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			parent=new int[n+1];
			for(int i=1;i<=n;i++) {
				parent[i]=i;
			}
			sb=new StringBuilder();
			sb.append("#"+(x+1)+" ");
			
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				int command=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				if(command==0) {
					if(a==b);
					else if(findSet(a)!=findSet(b)) {
						parent[findSet(b)]=findSet(a);
					}
				}
				
				else if(command==1) {
					if(a==b)sb.append(1);
					else if(findSet(a)==findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb.toString());
		}
	}

}



