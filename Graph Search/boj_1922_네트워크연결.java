package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1922_네트워크연결 {

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
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		ArrayList<Edge>[] adj=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b,c));
			adj[b].add(new Edge(a,c));
		}
		
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		boolean[] visited=new boolean[N+1];
		pq.add(new Edge(1,0));
		int count=0,answer=0;
		
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
			if(visited[cur.to])continue;
			visited[cur.to]=true;
			answer+=cur.cost;
			if(++count==N) {
				System.out.println(answer);
				return;
			}
			for(Edge e:adj[cur.to]) {
				if(!visited[e.to])pq.add(e);
			}
		}
	}

}
