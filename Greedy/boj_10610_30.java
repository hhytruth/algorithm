package algorithm.greedy;
import java.io.*;
import java.util.*;

public class boj_10610_30 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String N=br.readLine();
		Integer[] arr=new Integer[N.length()];
		boolean zero=false;
		int sum=0;
		for(int i=0;i<N.length();i++) {
			arr[i]=N.charAt(i)-'0';
			sum+=arr[i];
			if(arr[i]==0)zero=true;
		}
		
		if(!zero||sum%3!=0)System.out.println(-1);
		else {
			Arrays.sort(arr,Collections.reverseOrder());
			for(int i:arr) {
				System.out.print(i);
			}
			System.out.println();
		}
		

	}

}
