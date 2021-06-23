package algorithm.permutation;
import java.io.*;
import java.util.*;

public class boj_10974_모든순열 {

	static int[] arr;
	
	public static boolean nextPermutation(int N) {
		
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		int top=N-1;
		while(top>0&&arr[top]<=arr[top-1])top--;
		if(top<=0) return false;
		
		int j=N-1;
		while(arr[top-1]>arr[j])j--;
		
		int tmp=arr[j];
		arr[j]=arr[top-1];
		arr[top-1]=tmp;

		Arrays.sort(arr, top, N);
		
		
		return true;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		
		while(true) {
			if(!nextPermutation(N))break;
		}
		
	}

}
