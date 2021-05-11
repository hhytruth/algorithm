package swing;
import java.io.*;
import java.util.*;

public class boj_14395_4연산 {

	public static class Node{
		int num;
		String command;
		Node(int n,String c){
			num=n;
			command=c;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int s=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		int max=1000000001;
		boolean[] visited=new boolean[max];
		visited[s]=true;
		Queue<Node> queue=new LinkedList<>();
		queue.add(new Node(s,""));
		if(s==t) {
			System.out.println(0);
			return;
		}
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			int num=node.num;
			String command=node.command;
			if(num==t) {
				System.out.println(command);
				return;
			}
			
			if((long)num*(long)num<max&&num*num>=0&&!visited[num*num]) {
				visited[num*num]=true;
				queue.add(new Node(num*num,command+"*"));
			}
			if((long)num+(long)num<max&&num+num>=0&&!visited[num+num]) {
				visited[num+num]=true;
				queue.add(new Node(num+num,command+"+"));
			}
			if(!visited[num-num]) {
				visited[num-num]=true;
				queue.add(new Node(num-num,command+"-"));
			}
			if(num!=0&&!visited[num/num]) {
				visited[num/num]=true;
				queue.add(new Node(num/num,command+"/"));
			}
		}
		System.out.println(-1);
	}

}
