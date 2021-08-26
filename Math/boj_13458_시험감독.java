package atest;
import java.io.*;
import java.util.*;

public class boj_13458_시험감독 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] students=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			students[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		long sum=0;
		for(int i=0;i<N;i++) {
			sum++;
			if(students[i]-B<=0)continue;
			if((students[i]-B)%C==0)sum+=(students[i]-B)/C;
			else sum+=(students[i]-B)/C+1;		
		}
		
		System.out.println(sum);
	}

}
