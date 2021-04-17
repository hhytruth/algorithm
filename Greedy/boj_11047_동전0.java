package algorithm.greedy;
import java.io.*;
import java.util.*;

public class boj_11047_동전0 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Integer[] coins=new Integer[N];
		for(int i=0;i<N;i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coins,Collections.reverseOrder());
		int sum=0;
		int count=0;
		for(int i=0;i<N;i++) {
			while(K-sum>=coins[i]) {
				count++;
				sum+=coins[i];
			}
			
		}
		
		System.out.println(count);
	}

}
