package line;
import java.util.*;
import java.io.*;

public class boj_1865_웜홀 {
    
	static class Edge{
		int to,cost;
		Edge(int t,int c){
			to=t;
			cost=c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int a=0;a<TC;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int W=Integer.parseInt(st.nextToken());
			ArrayList<Edge> adj[]=new ArrayList[N+1];
			
			for(int i=0;i<=N;i++) {
				adj[i]=new ArrayList<>();
			}
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int S=Integer.parseInt(st.nextToken());
				int E=Integer.parseInt(st.nextToken());
				int T=Integer.parseInt(st.nextToken());
				adj[S].add(new Edge(E,T));
				adj[E].add(new Edge(S,T));
			}
			
			for(int i=0;i<W;i++) {
				st=new StringTokenizer(br.readLine());
				int S=Integer.parseInt(st.nextToken());
				int E=Integer.parseInt(st.nextToken());
				int T=Integer.parseInt(st.nextToken());
				adj[S].add(new Edge(E,-1*T));
			}
			
			int INF=987654321;
			boolean update=false;
			int[] dist=new int[N+1];
			boolean minusCycle=false;
			Arrays.fill(dist, INF);
			dist[1]=0;
			for(int i=1;i<=N;i++) {
				update=false;
				for(int j=1;j<=N;j++) {
					for(Edge next:adj[j]) {
						if(dist[next.to]>dist[j]+next.cost) {
							dist[next.to]=dist[j]+next.cost;
							update=true;
							if(i==N) {
								minusCycle=true;
								break;
							}
						}
					}
					if(minusCycle)break;
				}
				if(minusCycle)break;
				if(!update)break;
			}			
			
			if(update)System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
