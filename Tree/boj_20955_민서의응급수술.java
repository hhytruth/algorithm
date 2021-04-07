package algorithm.tree;
import java.util.*;
import java.io.*;

public class boj_20955_민서의응급수술 {

	static int[] parent;
	
	public static int findSet(int x) {
		if(parent[x]==x)return x;
		else return parent[x]=findSet(parent[x]);
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
		
		int cycle=0;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int paru=findSet(u);
			int parv=findSet(v);
			if(paru!=parv)parent[parv]=paru;
			else cycle++;
		}
		
		boolean[] sets=new boolean[N+1];
		int setNum=0;
		for(int i=1;i<=N;i++) {
			int pari=findSet(i);
			if(!sets[pari]) {
				sets[pari]=true;
				setNum++;
			}
		}
		
		System.out.println(setNum-1+cycle);
	}

}
