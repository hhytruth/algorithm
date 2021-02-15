package off.day4.sol1;
import java.util.*;
import java.io.*;

public class Dwarf {
	
	public static void comb(int[] arr,boolean[] visited,int[] result,int sum,int n,int r,int depth,int idx) {
		
		if(r==0) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(result[i]);
				}
			}
			return;
		}
		if(depth==n)return;
		
		visited[depth]=true;
		result[idx]=arr[depth];
		comb(arr,visited,result,sum+arr[depth],n,r-1,depth+1,idx+1);
		
		visited[depth]=false;
		comb(arr,visited,result,sum,n,r,depth+1,idx);
		
	}
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] dwarves=new int[9];
		boolean[] visited=new boolean[9];
		for(int i=0;i<9;i++) {
			int number=Integer.parseInt(br.readLine());
			dwarves[i]=number;
		}
		int[] result=new int[7];
		comb(dwarves,visited,result,0,9,7,0,0);
		
		
		
	}
}
