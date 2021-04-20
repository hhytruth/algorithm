package algorithm.bruteforce;
import java.io.*;
import java.util.*;

class Node{
	int num;
	String commands;
	Node(int n,String c){
		num=n;
		commands=c;
	}
}

public class boj_9019 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int initial=Integer.parseInt(st.nextToken());
			int goal=Integer.parseInt(st.nextToken());
			boolean[] visited=new boolean[10000];
			Queue<Node> queue=new LinkedList<>();
			visited[initial]=true;
			queue.add(new Node(initial,""));
			while(!queue.isEmpty()) {
				Node node=queue.poll();
				int num=node.num;
				String command=node.commands;
				
				int D=2*num%10000;
				int S=num-1;
				if(num==0)S=9999;
				int d1=num/1000;
				int d4=num%10;
				int L=(num%1000)*10+d1;
				int R=num/10+d4*1000;
				
				if(!visited[D]) {
					visited[D]=true;
					queue.add(new Node(D,command+"D"));
					if(D==goal) {
						System.out.println(command+"D");
						break;
					}
				}
				if(!visited[S]) {
					visited[S]=true;
					queue.add(new Node(S,command+"S"));
					if(S==goal) {
						System.out.println(command+"S");
						break;
					}
				}
				if(!visited[L]) {
					visited[L]=true;
					queue.add(new Node(L,command+"L"));
					if(L==goal) {
						System.out.println(command+"L");
						break;
					}
				}
				if(!visited[R]) {
					visited[R]=true;
					queue.add(new Node(R,command+"R"));
					if(R==goal) {
						System.out.println(command+"R");
						break;
					}
				}
				
			}
		}
	}

}
