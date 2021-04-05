package algorithm.graph;
import java.util.*;
import java.io.*;

public class boj_2644_촌수계산 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader	br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n1=Integer.parseInt(st.nextToken());
		int n2=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj=new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			adj[x-1].add(y-1);
			adj[y-1].add(x-1);
		}
		
		int chon=1;
		Queue<Integer> queue=new LinkedList<>();
		queue.add(n1-1);
		boolean[] visited=new boolean[n];
		visited[n1-1]=true;
		int adjNum=1;
		int adjNum2=0;
		boolean found=false;
		while(!queue.isEmpty()) {
			for(int j=0;j<adjNum;j++) {
				if(found) {
					queue.clear();
					break;
				}
				int now=queue.poll();
				
				for(int i=0;i<adj[now].size();i++) {
					int next=adj[now].get(i);
					if(next==n2-1) {
						System.out.println(chon);
						found=true;
						break;
					}
					if(visited[next])continue;
					queue.add(next);
					visited[next]=true;
					adjNum2++;
				}	
				
			}
			adjNum=adjNum2;
			adjNum2=0;
			chon++;
		}
		
		if(!found)System.out.println(-1);
	}
}
