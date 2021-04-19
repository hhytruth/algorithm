package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_5014_스타트링크 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int F=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		int G=Integer.parseInt(st.nextToken());
		int U=Integer.parseInt(st.nextToken());
		int D=Integer.parseInt(st.nextToken());
		Queue<Integer[]> queue=new LinkedList<>();
		boolean[] visited=new boolean[F+1];
		if(S==G) {
			System.out.println(0);
		}
		else {
			queue.add(new Integer[] {S,0});
			visited[S]=true;
			while(!queue.isEmpty()) {
				Integer[] cur=queue.poll();
				int floor=cur[0];
				int count=cur[1];
				if(floor+U<=F) {	
					if(!visited[floor+U]) {
						queue.add(new Integer[] {floor+U,count+1});
						visited[floor+U]=true;
						if(floor+U==G) {
							System.out.println(count+1);
							return;
						}
					}
					
				}
				if(floor-D>=1) {
					if(!visited[floor-D]) {
						queue.add(new Integer[] {floor-D,count+1});
						visited[floor-D]=true;
						if(floor-D==G) {
							System.out.println(count+1);
							return;
						}
					}
					
				}
			}
			
			System.out.println("use the stairs");
		}
	}

}
