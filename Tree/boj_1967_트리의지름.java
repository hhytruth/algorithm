package algorithm.tree;
import java.util.*;
import java.io.*;

public class boj_1967_트리의지름 {

	static int max=0;
	public static int dfs(ArrayList<Integer[]>[] adj,boolean[] visited,int cur,ArrayList<Integer>[] radius,int sum) {
		
		visited[cur]=true;
		if(adj[cur].size()==0) {
			radius[cur].add(0);
			return 0;
		}
		for(int i=0;i<adj[cur].size();i++) {
			Integer[] next=adj[cur].get(i);
			if(!visited[next[0]]) {
				sum=dfs(adj,visited,next[0],radius,0);
				int t=next[1];
				radius[cur].add(sum+next[1]);
				//radius[cur].add(radius[next[0]].get(radius[next[0]].size()-1)+next[1]);
			}
		}
		if(radius[cur].size()>1) {
			Collections.sort(radius[cur],Collections.reverseOrder());
			
			int tmp=radius[cur].get(0)+radius[cur].get(1);
			if(max<tmp)max=tmp;
			return Collections.max(radius[cur]);
		}
		else if(radius[cur].size()==1) {
			int tmp=radius[cur].get(0);
			if(max<tmp)max=tmp;
			return tmp;
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ArrayList<Integer[]>[] adj=new ArrayList[10001];
		for(int i=0;i<10001;i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			adj[parent].add(new Integer[] {child,weight});
		}
		
		ArrayList<Integer>[] radius=new ArrayList[10001];
		for(int i=0;i<10001;i++) {
			radius[i]=new ArrayList<>();
		}
		
		boolean[] visited=new boolean[10001];
		dfs(adj,visited,1,radius,0);
		
		System.out.println(max);
	}

}
