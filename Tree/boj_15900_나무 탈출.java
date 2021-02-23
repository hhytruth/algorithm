package algorithm.tree;
import java.io.*;
import java.util.*;



public class boj_15900 {
	
	static List<Integer>[] adj;	//연결되어 있는 노드 리스트 배열
	static int sum=0;	//결과
	
	public static void dfs(boolean[] visited,int height,int node) {
		if(visited[node-1]) return;
		if(adj[node-1].size()==1&&!visited[node-1]) {	//연결되어 있는 노드 개수가 1인 노드는 리프 노드
			sum+=height;
		}
		visited[node-1]=true;
		
		for(int n:adj[node-1]) {
			if(!visited[n-1]) dfs(visited,height+1,n);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		adj=new ArrayList[N];
		for(int x=0;x<N;x++) {
			adj[x]=new ArrayList<>();
		}
		
		for(int x=0;x<N-1;x++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			adj[a-1].add(b);
			adj[b-1].add(a);			
		}
		
		boolean[] visited=new boolean[N];
		dfs(visited,0,1);
		
		
		if(sum%2==0)System.out.println("No");	//리프노드에서 루트 노드까지의 높이를 다 더해서 짝수이면 진다
		else System.out.println("Yes");
	}
}
