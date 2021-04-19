package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_1697_숨바꼭질 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Queue<Integer[]> queue=new LinkedList<>();
		boolean[] visited=new boolean[100001];
		queue.add(new Integer[] {N,0});
		visited[N]=true;
		if(N==K) {
			System.out.println(0);
			return;
		}
		while(!queue.isEmpty()) {
			Integer[] cur=queue.poll();
			int curn=cur[0];
			int curtime=cur[1];
			if(curn>0&&!visited[curn-1]) {
				visited[curn-1]=true;
				if(curn-1==K) {
					System.out.println(curtime+1);
					return;
				}
				queue.add(new Integer[] {curn-1,curtime+1});
			}
			if(curn<100000&&!visited[curn+1]) {
				visited[curn+1]=true;
				if(curn+1==K) {
					System.out.println(curtime+1);
					return;
				}
				queue.add(new Integer[] {curn+1,curtime+1});
			}
			if(curn*2<=100000&&!visited[curn*2]) {
				visited[curn*2]=true;
				if(curn*2==K) {
					System.out.println(curtime+1);
					return;
				}
				queue.add(new Integer[] {curn*2,curtime+1});
			}		
		}
	}
}
