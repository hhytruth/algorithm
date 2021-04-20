package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_1963_소수경로 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		boolean[] notprime=new boolean[10000];
		for(int i=2;i<=100;i++) {
			if(!notprime[i]) {
				for(int j=i*i;j<10000;j+=i) {
					notprime[j]=true;
				}
			}
		}
		
		for(int a=0;a<T;a++) {
			int min=Integer.MAX_VALUE;
			StringTokenizer st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int goal=Integer.parseInt(st.nextToken());
			boolean[] visited=new boolean[10000];
			visited[start]=true;
			if(goal==start) {
				System.out.println(0);
				continue;
			}
			Queue<Integer> queue=new LinkedList<>();
			queue.add(start);
			int count=0;
			int qsize=1,qsize2=0;
			boolean found=false;
			while(!queue.isEmpty()) {
				for(int k=0;k<qsize;k++) {
					int cur=queue.poll();
					for(int i=0;i<4;i++) {
						int orig=(int)(cur%Math.pow(10, i+1)-cur%Math.pow(10, i));
						for(int j=0;j<10;j++) {
							int next=(int)(cur-orig+j*Math.pow(10, i));
							if(!visited[next]&&!notprime[next]&&next>=1000) {
								queue.add(next);
								visited[next]=true;
								qsize2++;
								if(next==goal) {
									System.out.println(count+1);
									found=true;
									break;
								}
							}
						}
						if(found)break;
					}
					if(found)break;
				}
				if(found)break;
				
				qsize=qsize2;
				qsize2=0;
				count++;
			}
			if(!found) System.out.println("Impossible");
		}
		
	}

}
