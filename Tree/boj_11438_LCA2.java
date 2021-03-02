package algorithm.tree;
import java.util.*;
import java.io.*;

public class boj_11438_LCA2 {
	
	static ArrayList<ArrayList<Integer>> adj;
	static int[] depth;
	static int[][] parent;
	
	public static void dfs(int node,int cnt) {
		depth[node]=cnt;
		for(int n:adj.get(node)) {
			if(depth[n]!=0)continue;
			parent[n][0]=node;
			dfs(n,cnt+1);
		}
	}
	
	public static void setParent(int n,int maxDepth) {
		for(int i=1;i<maxDepth;i++) {
			for(int j=1;j<=n;j++) {
				parent[j][i]=parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	public static int solve(int n1,int n2,int maxDepth) {
		if(depth[n1]>depth[n2]) {
			int tmp=n1;
			n1=n2;
			n2=tmp;
		}
		
		for(int i=maxDepth-1;i>=0;i--) {
			if(depth[n1]<=depth[parent[n2][i]])n2=parent[n2][i];
		}
		
		if(n1==n2)return n1;
		for(int i=maxDepth-1;i>=0;i--) {
			if(parent[n1][i]!=parent[n2][i]) {
				n1=parent[n1][i];
				n2=parent[n2][i];
			}
		}
		return parent[n1][0];
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		adj=new ArrayList<>();
		int maxDepth=0;
		int check=1;
		while(check<=N) { // 트리의 깊이 계산
			check<<=1;
			maxDepth++;
		}
		for(int i=0;i<=N;i++)adj.add(new ArrayList<>());
		depth=new int[N+1];
		parent=new int[N+1][maxDepth+1];
		
		
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			adj.get(n1).add(n2);
			adj.get(n2).add(n1);
		}
		
		dfs(1,1);
		setParent(N,maxDepth);
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			System.out.println(solve(n1,n2,maxDepth));
		}		
	}	
}
