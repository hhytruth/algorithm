package algorithm.divideNconquer;
import java.util.*;
import java.io.*;

public class boj_1517_버블소트 {
 
	static int[] sorted;
	static long swap=0;
	
	public static void merge(int[] arr,int left, int mid, int right) {
		
		int i,j,k,l;
		i=left;
		j=mid+1;
		k=left;
		
		while(i<=mid&&j<=right) {
			
			if(arr[i]<=arr[j])sorted[k++]=arr[i++];
			else {
				sorted[k++]=arr[j++];
				swap+=j-k;
			}
		}
		
		if(i>mid) {
			for(l=j;l<=right;l++) {
				sorted[k++]=arr[l];
			}
		}
		else {
			for(l=i;l<=mid;l++) {
				sorted[k++]=arr[l];
			}
		}
		
		for(l=left;l<=right;l++) {
			arr[l]=sorted[l];
		}
	}
	
	public static void mergeSort(int[] arr,int left,int right) {
		
		int mid;
		
		if(left<right) {
			mid=(left+right)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int A=Integer.parseInt(st.nextToken());
			arr[i]=A;
		}
		
		sorted=new int[N];
		mergeSort(arr,0,N-1);
		System.out.println(swap);
		
	}

}
