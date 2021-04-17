package algorithm.greedy;
import java.io.*;
import java.util.*;

public class boj_11399_ATM {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] draw=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			draw[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(draw);
		int result=0;
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=draw[i];
			result+=sum;
		}
		
		System.out.println(result);
		
	}

}
