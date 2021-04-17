package algorithm.greedy;
import java.io.*;
import java.util.*;

class Jewel implements Comparable<Jewel> {
	int M;
	int V;
	Jewel(int m,int v){
		M=m;
		V=v;
	}
	
	@Override
	public int compareTo(Jewel o) {
		return this.M-o.M;
	}
	
}

public class boj_1202_보석도둑 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Jewel[] jewels=new Jewel[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int V=Integer.parseInt(st.nextToken());
			jewels[i]=new Jewel(M,V);
		}
		Integer[] bags=new Integer[K];
		Arrays.sort(jewels);
		
		for(int i=0;i<K;i++) {
			bags[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bags);
		int count=0;
		long sum=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<K;i++) {
			
			while(count<N&&jewels[count].M<=bags[i]) {
				pq.add(jewels[count++].V);
			}
			if(!pq.isEmpty()) sum+=pq.poll();
			
		}
		
		System.out.println(sum);
	}

}
