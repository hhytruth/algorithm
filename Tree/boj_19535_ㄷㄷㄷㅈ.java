package algorithm.tree;
import java.util.*;
import java.io.*;

public class boj_19535_ㄷㄷㄷㅈ {
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long[][] edges=new long[N-1][2];
		long[] degree=new long[N+1];
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			edges[i][0]=u;
			edges[i][1]=v;
			degree[u]++;
			degree[v]++;
		}
		
		long d=0,g=0;
		for(int i=0;i<N-1;i++) {
			long u=edges[i][0];
			long v=edges[i][1];
			d+=(degree[(int) u]-1)*(degree[(int) v]-1);
		}
		
		for(int i=1;i<=N;i++) {
			g+=degree[i]*(degree[i]-1)*(degree[i]-2)/6;
		}
		
		if(d>3*g)System.out.println("D");
		else if(d<3*g)System.out.println("G");
		else if(d==3*g)System.out.println("DUDUDUNGA");
		
		
	}

}
