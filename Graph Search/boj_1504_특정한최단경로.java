package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1504_특정한최단경로 {

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
		int N=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] adj=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b,c));
			adj[b].add(new Edge(a,c));
		}
		st=new StringTokenizer(br.readLine());
		int v1=Integer.parseInt(st.nextToken());
		int v2=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		boolean[] visited=new boolean[N+1];
		pq.add(new Edge(1,0));
		long[] d=new long[N+1];
		Arrays.fill(d,800001 );
		d[1]=0;
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
	//		if(visited[cur.to])continue;
			visited[cur.to]=true;
			for(Edge e:adj[cur.to]) {
				if(d[e.to]>d[cur.to]+e.cost) {
					d[e.to]=d[cur.to]+e.cost;
					pq.add(e);
				}
			}
		}
		
		long stov1=d[v1];
		long stov2=d[v2];
		if(stov1>=800001||stov2>=800001) {
			System.out.println(-1);
			return;
		}
		pq.clear();
		visited=new boolean[N+1];
		pq.add(new Edge(v1,0));
		d=new long[N+1];
		Arrays.fill(d, 800001);
		d[v1]=0;
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
//			if(visited[cur.to])continue;
			visited[cur.to]=true;
			for(Edge e:adj[cur.to]) {
				if(d[e.to]>d[cur.to]+e.cost) {
					d[e.to]=d[cur.to]+e.cost;
					pq.add(e);
				}
			}
		}
		long v1tov2=d[v2];
		if(v1tov2>=800001) {
			System.out.println(-1);
			return;
		}
		
		pq.clear();
		visited=new boolean[N+1];
		pq.add(new Edge(N,0));
		d=new long[N+1];
		Arrays.fill(d, 800001);
		d[N]=0;
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
		//	if(visited[cur.to])continue;
			visited[cur.to]=true;
			for(Edge e:adj[cur.to]) {
				if(d[e.to]>d[cur.to]+e.cost) {
					d[e.to]=d[cur.to]+e.cost;
					pq.add(e);
				}
			}
		}
		long etov1=d[v1];
		long etov2=d[v2];
		if(etov1>=800001||etov2>=800001) {
			System.out.println(-1);
			return;
		}
		
		long answer=Math.min((long)(stov1+v1tov2+etov2), (long)(stov2+v1tov2+etov1));
		if(answer>=800001) System.out.println(-1);
		else System.out.println(answer);
	
	}

}
