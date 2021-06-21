package algorithm.math;
import java.io.*;
import java.util.*;

public class boj_1500_최대곱 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int S=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[100];
		for(int i=0;i<K;i++) {
			arr[i]=S/K;
		}
		int sum=arr[0]*K;
		for(int i=0;i<S-sum;i++) {
			arr[i]++;
		}
		
		long result=1;
		for(int i=0;i<K;i++) {
			result*=arr[i];
		}
		
		System.out.println(result);

	}

}
