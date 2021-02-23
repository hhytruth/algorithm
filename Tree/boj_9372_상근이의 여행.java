package algorithm.tree;
import java.util.*;
import java.io.*;

public class boj_9372 {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int x=0;x<T;x++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
			}
			System.out.println(N-1);	
			//어차피 그래프는 다 연결되어 있으므로 도시를 연결하는 간선의 최소 개수만큼 비행기가 필요하다
			//간선의 최소 개수=N-1(모든 국가를 다 방문하므로)
		}
		
		
	}
	
}
