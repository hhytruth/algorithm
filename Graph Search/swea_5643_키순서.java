import java.io.*;
import java.util.*;

public class swea_5643_키순서 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int x=0;x<T;x++) {
			
			int N=Integer.parseInt(br.readLine());
			int M=Integer.parseInt(br.readLine());
			StringTokenizer st;
			ArrayList<Integer>[] out=new ArrayList[N+1];
			ArrayList<Integer>[] in=new ArrayList[N+1];
			for(int i=0;i<=N;i++) {
				out[i]=new ArrayList<>();
				in[i]=new ArrayList<>();
			}
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				out[a].add(b);
				in[b].add(a);
			}
			
			int answer=0;
			
			for(int i=1;i<=N;i++) {
				Queue<Integer> queue=new LinkedList<>();
				int indegree=0,outdegree=0;
				queue.add(i);
				boolean[] visited=new boolean[N+1];
				while(!queue.isEmpty()) {
					int cur=queue.poll();
					for(int j=0;j<in[cur].size();j++) {
						int next=in[cur].get(j);
						if(!visited[next]) {
							queue.add(in[cur].get(j));
							indegree++;	
							visited[next]=true;
						}
					}
				}
				
				queue.add(i);
				visited=new boolean[N+1];
				while(!queue.isEmpty()) {
					int cur=queue.poll();
					for(int j=0;j<out[cur].size();j++) {
						int next=out[cur].get(j);
						if(!visited[next]) {
							queue.add(out[cur].get(j));
							outdegree++;	
							visited[next]=true;
						}
					}
				}
				
				if(indegree+outdegree+1==N)answer++;
			}
			
			System.out.println("#"+(x+1)+" "+answer);
		}
	}

}
