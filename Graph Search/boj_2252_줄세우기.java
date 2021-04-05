package algorithm.graph;
import java.util.*;
import java.io.*;

public class boj_2252_줄세우기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] in=new ArrayList[N];
		ArrayList<Integer>[] out=new ArrayList[N];
		for(int i=0;i<N;i++) {
			in[i]=new ArrayList<>();
			out[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			in[B-1].add(A-1);	
			out[A-1].add(B-1);
		}
		int[] result=new int[N];
		Queue<Integer> queue=new LinkedList<>();
		for(int i=0;i<N;i++) {
			if(in[i].size()==0)queue.add(i);
		}
		int idx=0;
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			result[idx++]=cur;
			for(int i=0;i<out[cur].size();i++) {
				int next=out[cur].get(i);
				in[next].remove((Object)cur);
				if(in[next].size()==0)queue.add(next);
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(result[i]+1+" ");
		}
		System.out.println();
	}

}
