package com.inner;
import java.io.*;
import java.util.*;

public class Mart {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int a=0;a<TC;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int[] arr=new int[N];

			st=new StringTokenizer(br.readLine());

			for(int i=0;i<N;i++) {
				int weight=Integer.parseInt(st.nextToken());
				arr[i]=weight;
			}
			Arrays.sort(arr);
			int max=-1;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(arr[i]+arr[j]<=M&&max<arr[i]+arr[j]) {
						max=arr[i]+arr[j];
					}
					if(arr[i]+arr[j]>max)break;
				}
			}
			
			
			
			System.out.println("#"+(a+1)+" "+max);
			
			
		}
	}
	
}
