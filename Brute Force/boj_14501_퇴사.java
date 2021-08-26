package atest;
import java.io.*;
import java.util.*;

public class boj_14501_퇴사 {

	static int N, max;
	static int[] arrT,arrP,result;
	
	public static void recur(int sum, int day) {
		
		if(day>N)return;
		recur(sum,day+1);

		if(arrT[day-1]+day-1<=N) {
			sum+=arrP[day-1];
			if(sum>max)max=sum;
			recur(sum,day+arrT[day-1]);
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arrT=new int[N];
		arrP=new int[N];
		result=new int[N];

		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arrT[i]=Integer.parseInt(st.nextToken());
			arrP[i]=Integer.parseInt(st.nextToken());
			result[i]=arrP[i];
		}
		
		max=0;
		for(int i=0;i<N;i++) {
			if(arrT[i]+i<=N) {
				recur(0,i+1);
			}
		}
		
		System.out.println(max);
		
	}

}
