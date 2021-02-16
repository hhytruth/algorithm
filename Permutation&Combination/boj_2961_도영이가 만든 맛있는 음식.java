package off.day4.sol1;
import java.util.*;
import java.io.*;

public class Food {
	static int minDiff=1000000000;
	public static void powerset(int[][] arr,boolean[] visited,int n,int idx, int sour,int bitter) {
		
		if(idx==n) {
			if(sour!=-1) {
				int diff=Math.abs(sour-bitter);
				if(minDiff>diff)minDiff=diff;	
			}
			
			return;
		}
		
		visited[idx]=false;
		powerset(arr,visited,n,idx+1,sour,bitter);
		
		if(sour==-1) {
			sour=1;
			bitter=0;
		}
		visited[idx]=true;
		sour*=arr[idx][0];
		bitter+=arr[idx][1];
		powerset(arr,visited,n,idx+1,sour,bitter);
		
		
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] ingredients=new int[N][2];
		boolean[] visited=new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int sour=Integer.parseInt(st.nextToken());
			int bitter=Integer.parseInt(st.nextToken());
			int[] ingredient= {sour,bitter};
			ingredients[i]=ingredient;
			
		}
		
		powerset(ingredients,visited,N,0,-1,-1);
		System.out.println(minDiff);
	}
	
}
