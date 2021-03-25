package swing;

import java.io.*;
import java.util.*;

public class boj_2565_전깃줄 {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] atob=new int[501];
		int[] LIS=new int[501];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			atob[A]=B;
		}
		
		int max=0;
		for(int i=1;i<501;i++) {
			if(atob[i]==0)continue;
			LIS[i]=1;
			for(int j=1;j<i;j++) {
				if(atob[j]<atob[i]&&LIS[i]<1+LIS[j]) {
					LIS[i]=1+LIS[j];
					if(max<LIS[i])max=LIS[i];
				}
			}
		}
		
		System.out.println(N-max);
		
		
		
	}
}
