package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_2056_작업 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] later=new ArrayList[N+1];
		int[] indegree=new int[N+1];
		for(int i=0;i<=N;i++) {
			later[i]=new ArrayList<>();
		}
		
		int[] times=new int[N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			times[i]=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++) {
				int work=Integer.parseInt(st.nextToken());
				later[work].add(i);
				indegree[i]++;
			}
		}
		
		int[] results=new int[N+1];
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				queue.add(i);
				results[i]=times[i];
			}
		}
		
		int min=0;
		
		while(!queue.isEmpty()) {
			int work=queue.poll();

			for(int i=0;i<later[work].size();i++) {
				int next=later[work].get(i);
				if(results[next]<results[work]+times[next]) {
					results[next]=results[work]+times[next];
				}
				if(--indegree[next]==0)queue.add(next);
			
			}
		}
		
		for(int i:results) {
			min=Math.max(min, i);
		}
		System.out.println(min);
	}

}
