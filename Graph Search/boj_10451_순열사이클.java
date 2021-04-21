package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_10451_순열사이클 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[] adj=new int[N+1];
			for(int i=1;i<=N;i++) {
				int num=Integer.parseInt(st.nextToken());
				adj[i]=num;
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
					int next=adj[cur];
					if(!visited[next]) {
						queue.add(next);
						visited[next]=true;
					}
				
				}
			}
			
			System.out.println(count);
		}
	}

}
