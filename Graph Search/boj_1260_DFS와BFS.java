package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1260_DFS와BFS {

	public static void dfs(ArrayList<Integer>[] adj,boolean[] visited,int cur) {
		
		visited[cur]=true;
		System.out.print(cur+" ");
		for(int i=0;i<adj[cur].size();i++) {
			int next=adj[cur].get(i);
			if(!visited[next]) {
				dfs(adj,visited,next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] adj=new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			adj[n1].add(n2);
			adj[n2].add(n1);
		}
		
		for(int i=0;i<=N;i++) {
			Collections.sort(adj[i]);
		}
		
		dfs(adj,new boolean[N+1],V);
		System.out.println();
		
		Queue<Integer> queue=new LinkedList<>();
		boolean[] visited=new boolean[N+1];
		queue.add(V);
		visited[V]=true;
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			System.out.print(cur+" ");
			for(int i=0;i<adj[cur].size();i++) {
				int next=adj[cur].get(i);
				if(!visited[next]) {
					visited[next]=true;
					queue.add(next);
				}
			}
		}
		System.out.println();
	}

}
