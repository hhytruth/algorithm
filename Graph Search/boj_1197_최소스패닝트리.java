package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1197_최소스패닝트리 {

	static int V,E;
	static ArrayList<Node>[] adj;
	static class Node implements Comparable<Node>{
		
		int to,weight;
		
		public Node(int to,int weight) {
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		adj=new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b,c));
			adj[b].add(new Node(a,c));
		}
		
		System.out.println(prim());
	}
	
	public static long prim() {
		
		boolean[] visited=new boolean[V+1];
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(1,0));
		long res=0;
		int cnt=0;
		while(!pq.isEmpty()) {
			Node edge=pq.poll();
			if(visited[edge.to])continue;
			res+=edge.weight;
			visited[edge.to]=true;
			if(++cnt==V) return res;
			
			for(int i=0;i<adj[edge.to].size();i++) {
				Node next=adj[edge.to].get(i);
				if(visited[next.to])continue;
				pq.add(next);
			}
		}
		return res;
	}

}
