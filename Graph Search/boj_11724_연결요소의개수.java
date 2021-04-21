package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_11724_연결요소의개수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] adj=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		boolean[] visited=new boolean[N+1];
		int count=0;
		for(int i=1;i<=N;i++) {
			if(visited[i])continue;
			Queue<Integer> queue=new LinkedList<>();
			queue.add(i);
			visited[i]=true;
			count++;
			while(!queue.isEmpty()) {
				int cur=queue.poll();
				for(int j=0;j<adj[cur].size();j++) {
					int next=adj[cur].get(j);
					if(!visited[next]) {
						queue.add(next);
						visited[next]=true;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
