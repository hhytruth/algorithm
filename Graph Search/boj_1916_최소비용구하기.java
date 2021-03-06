package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1916_최소비용구하기 {

	static class edge implements Comparable<edge>{
		int end;
		int cost;
		
		public edge() {};
		
		public edge(int e,int c) {
			end=e;
			cost=c;
		}

		@Override
		public int compareTo(edge o) {
			return this.cost-o.cost;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		ArrayList<edge>[] adj=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			adj[start].add(new edge(end,cost));
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int src=Integer.parseInt(st.nextToken());
		int dest=Integer.parseInt(st.nextToken());
		PriorityQueue<edge> pq=new PriorityQueue<>();
		boolean[] visited=new boolean[N+1];
		int[] d=new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		pq.add(new edge(src,0));
		d[src]=0;
		
		while(!pq.isEmpty()) {
			edge e=pq.poll();
			int end=e.end;
			if(visited[end])continue;
			visited[end]=true;
			for(edge next:adj[end]) {
				if(d[next.end]>=d[end]+next.cost) {
					d[next.end]=d[end]+next.cost;
					pq.add(new edge(next.end,d[next.end]));
				}
			}
		}
		
		System.out.println(d[dest]);
		
	}

}
