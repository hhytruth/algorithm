package algorithm.tree;
import java.util.*;
import java.io.*;

public class boj_11725_트리의부모찾기 {

	static int[] parent;
	
	public static void dfs(ArrayList<Integer>[] adj,boolean[] visited,int n) {
		
		visited[n]=true;
		for(int i=0;i<adj[n].size();i++) {
			int next=adj[n].get(i);
			if(!visited[next]) {
				parent[next]=n;
				dfs(adj,visited,next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj=new ArrayList[N];
		for(int i=0;i<N;i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			adj[n1-1].add(n2-1);
			adj[n2-1].add(n1-1);			
		}
		
		parent=new int[N];
		boolean[] visited=new boolean[N];
		dfs(adj,visited,0);
		
		for(int i=1;i<N;i++) {
			System.out.println(parent[i]+1);
		}
	}

}
