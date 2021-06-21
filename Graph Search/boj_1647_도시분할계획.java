package algorithm.graph;
import java.io.*;
import java.util.*;

class Edges implements Comparable<Edges>{
	
	int start;
	int end;
	int weight;
	
	public Edges(int s,int e,int w) {
		this.start=s;
		this.end=e;
		this.weight=w;
	}

	@Override
	public int compareTo(Edges o) {
		return this.weight-o.weight;
	}
}

public class boj_1647_도시분할계획 {

	static int[] parent;
	static ArrayList<Edges> edgelist;
	
	public static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	
	public static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x!=y)parent[y]=x;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		edgelist=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			edgelist.add(new Edges(start,end,weight));
		}
		
		parent=new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		Collections.sort(edgelist);
		int ans=0;
		int bigCost=0;
		for(int i=0;i<edgelist.size();i++) {
			Edges edge=edgelist.get(i);
			
			//cycle이 발생하는 간선의 제외
			if(find(edge.start)!=find(edge.end)) {
				ans+=edge.weight;
				union(edge.start,edge.end);
				bigCost=edge.weight;
			}
		}
		
		System.out.println(ans-bigCost);
		//마지막에 더한 값(가장 큰 값)을 제외함(두 마을을 잇는 간선)
	}

}
