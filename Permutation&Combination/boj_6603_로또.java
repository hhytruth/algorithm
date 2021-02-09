package algorithm;
import java.io.*;
import java.util.*;

public class permutation3 {

	static void comb(int[] arr,boolean[] visited,int[] result,int depth,int n,int r,int idx) {
		if(r==0) {
			for(int i=0;i<6;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		if(depth==n)return;
		
		visited[depth]=true;
		result[idx]=arr[depth];
		comb(arr,visited,result,depth+1,n,r-1,idx+1);
		
		visited[depth]=false;
		result[idx]=-1;
		comb(arr,visited,result,depth+1,n,r,idx);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			int[] arr=new int[k];
			boolean[] visited=new boolean[k];
			int[] result=new int[6];
			if(k==0)break;
			for(int i=0;i<k;i++) {
				int number=Integer.parseInt(st.nextToken());
				arr[i]=number;
			}
			
			comb(arr,visited,result,0,k,6,0);
			System.out.println();
			
		}
		
		
	}

}
