package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_9466_텀프로젝트 {

	static boolean[] visited;
	static boolean[] visited2;
	
	public static void dfs(int[] adj,int cur,ArrayList<Integer> result) {
		
		int next=adj[cur];
		result.add(cur);
		if(visited2[next]) {
			while(!result.isEmpty()&&result.get(0)!=next) {
				result.remove(0);
			}
			for(int i=0;i<result.size();i++) {
				visited[result.get(i)]=true;
			}
			return;
		}
		visited2[next]=true;
		dfs(adj,next,result);
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int n=Integer.parseInt(br.readLine());
			int[] adj=new int[n+1];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				adj[i]=Integer.parseInt(st.nextToken());
			}
			visited=new boolean[n+1];
			visited2=new boolean[n+1];
			
			for(int i=1;i<=n;i++) {
				ArrayList<Integer> result=new ArrayList<>();
				if(!visited2[i])dfs(adj,i,result);
			}
			
			int count=0;
			for(int i=1;i<=n;i++) {
				if(!visited[i]) count++;
			}
			
			System.out.println(count);
		}
	}

}
