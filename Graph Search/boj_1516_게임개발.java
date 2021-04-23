package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1516_게임개발 {

	static class Building implements Comparable<Building>{
		
		int time,num;
		
		Building(int n,int t){
			num=n;
			time=t;
		}

		@Override
		public int compareTo(Building o) {
			return this.time-o.time;
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Building>[] later=new PriorityQueue[N+1];
		int[] indegree=new int[N+1];
		for(int i=0;i<=N;i++) {
			later[i]=new PriorityQueue<>();
		}
		int[] times=new int[N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			times[i]=Integer.parseInt(st.nextToken());
			while(true) {
				int building=Integer.parseInt(st.nextToken());
				if(building==-1)break;
				else {
					indegree[i]++;
					later[building].add(new Building(i,times[i]));
				}
			}
		}
		
		int[] result=new int[N+1];
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				queue.add(i);
				result[i]=times[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			int size=later[cur].size();
			for(int i=0;i<size;i++) {
				int next=later[cur].poll().num;
				if(--indegree[next]==0) {
					queue.add(next);
				}
				result[next]=Math.max(result[next],result[cur]+times[next]);

			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.println(result[i]);
		}
	}

}
