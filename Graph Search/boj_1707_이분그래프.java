package algorithm.graph;
import java.util.*;
import java.io.*;

public class boj_1707_이분그래프 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		for(int a=0;a<K;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] adj=new ArrayList[V];
			for(int i=0;i<V;i++) {
				adj[i]=new ArrayList<>();
			}
			for(int i=0;i<E;i++) {
				st=new StringTokenizer(br.readLine());
				int v1=Integer.parseInt(st.nextToken());
				int v2=Integer.parseInt(st.nextToken());
				adj[v1-1].add(v2-1);
				adj[v2-1].add(v1-1);
			}
			boolean result=true;
			boolean[] checked=new boolean[V];
			for(int i=0;i<V;i++) {
				if(!result)break;
				if(checked[i])continue;
				Queue<Integer> queue=new LinkedList<>();
				int[] color=new int[V];
				queue.add(i);
				color[i]=1;
				
				while(!queue.isEmpty()) {
					int now=queue.poll();
					checked[now]=true;
					int nowColor=color[now];
					int nextColor;
					if(nowColor==1)nextColor=2;
					else nextColor=1;
					for(int j=0;j<adj[now].size();j++) {
						int next=adj[now].get(j);
						if(color[next]==0) {
							color[next]=nextColor;
							queue.add(next);
						}
						else if(nextColor!=color[next]) {
							System.out.println("NO");
							queue.clear();
							result=false;
							break;
						}
					}
				}
				
			}
			if(result)System.out.println("YES");			
		}
	}

}
