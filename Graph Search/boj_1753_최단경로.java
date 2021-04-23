package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1753_최단경로 {

	static class Edge implements Comparable<Edge>{
		
		int to,cost;
		
		Edge(int t,int c){
			to=t;
			cost=c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(br.readLine());
		int INF=100_000_000;
		ArrayList<Edge>[] adj=new ArrayList[V+1];
		for(int i=0;i<=V;i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v,w));
		}
		
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		int[] d=new int[V+1];
		pq.add(new Edge(K,0));
		Arrays.fill(d,INF);
		d[K]=0;
		boolean[] visited=new boolean[V+1];
		
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
		//	if(cur.cost>d[cur.to])continue;
			if(visited[cur.to])continue;
			visited[cur.to]=true;
			
			for(Edge next:adj[cur.to]) {
				if(d[next.to]>d[cur.to]+next.cost) {
					d[next.to]=d[cur.to]+next.cost;
					pq.add(new Edge(next.to,d[next.to]));
				}
			}
		}
		
		for(int i=1;i<=V;i++) {
			if(d[i]!=INF)System.out.println(d[i]);
			else System.out.println("INF");
		}
	}

}
