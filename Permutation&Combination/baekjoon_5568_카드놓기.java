package algorithm;
import java.util.*;
import java.io.*;

public class permutation1 {
	
	static Set<String> set=new HashSet<>();
	public static void make(String s,int[] arr,boolean[] visited,int depth,int n,int r) {
		if(depth==r) {
			set.add(s);
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				visited[i]=true;
				int lengthBefore=s.length();
				s+=arr[i];
				make(s,arr,visited,depth+1,n,r);
				visited[i]=false;
				
				s=s.substring(0, lengthBefore);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		int[] cards=new int[n];
		boolean[] visited=new boolean[n];
		
		for(int i=0;i<n;i++) {
			int card=Integer.parseInt(br.readLine());
			cards[i]=card;
		}
		make("",cards,visited,0,n,k);
		System.out.println(set.size());
		
	}
}
