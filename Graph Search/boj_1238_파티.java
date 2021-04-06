package algorithm.graph;
import java.util.*;
import java.io.*;

class Edge{
	int start;
	int end;
	int dist;
	public Edge() {};
	public Edge(int s,int e,int d) {
		start=s;
		end=e;
		dist=d;
	}
}

class Pair implements Comparable<Pair>{
	int v;
	int dist;
	Pair(int v,int d){
		this.v=v;
		dist=d;
	}
	
	@Override
	public int compareTo(Pair o) {
		return dist-o.dist;
	}
}

public class boj_1238_파티 {
	
	static int INF=1000001;
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] adj=new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int T=Integer.parseInt(st.nextToken());
			Edge edge=new Edge(start-1,end-1,T);
			adj[start-1].add(edge);
		}
		
		int max=0;
		for(int i=0;i<N;i++) {
			int[] d1=new int[N];
			Arrays.fill(d1, INF);
			d1[i]=0;
			PriorityQueue<Pair> pq=new PriorityQueue<>();
			pq.add(new Pair(i,0));
			
			while(!pq.isEmpty()) {
				Pair p=pq.poll();
				if(d1[p.v]<p.dist)continue;
				for(int j=0;j<adj[p.v].size();j++) {
					Edge e=adj[p.v].get(j);
					int sum=e.dist+p.dist;
					if(d1[e.end]<sum)continue;
					d1[e.end]=sum;
					pq.add(new Pair(e.end,sum));
				}
			}
			
			int[] d2=new int[N];
			Arrays.fill(d2, INF);
			d2[X-1]=0;
			pq=new PriorityQueue<>();
			pq.add(new Pair(X-1,0));
			while(!pq.isEmpty()) {
				Pair p=pq.poll();
				if(d2[p.v]<p.dist)continue;
				for(int j=0;j<adj[p.v].size();j++) {
					Edge e=adj[p.v].get(j);
					int sum=e.dist+p.dist;
					if(d2[e.end]<sum)continue;
					d2[e.end]=sum;
					pq.add(new Pair(e.end,sum));
				}
			}
			
			if(max<d1[X-1]+d2[i])max=d1[X-1]+d2[i];
			
		}
		
		System.out.println(max);
		
		
	}

}
