package off.day4.sol1;
import java.util.*;
import java.io.*;

public class swea_6808 {

	public static int[] nextPermutation(int[] arr,int N) {
		int top=0;
		for(int i=N-1;i>0;i--) {
			if(arr[i-1]<arr[i]) {
				top=i;
				break;
			}
		}
		if(top>0) {
			for(int i=N-1;i>=top;i--) {
				if(arr[top-1]<arr[i]) {
					int tmp=arr[top-1];
					arr[top-1]=arr[i];
					arr[i]=tmp;
					break;
				}
			}		
		}
	
		Arrays.sort(arr, top, N);
		return arr;
	}
	
	public static void main(String args[])throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int[] kyuyoung=new int[9];
			int[] inyoung=new int[9];
			boolean[] cards=new boolean[18];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				int card=Integer.parseInt(st.nextToken());
				cards[card-1]=true;//true가 규영
				kyuyoung[i]=card;				
			}
			
			int idx=0;
			for(int i=0;i<18;i++) {
				if(cards[i]==false)inyoung[idx++]=i+1;
			}
			
			int win=0;
			int lose=0;
			for(int i=0;i<362880;i++) {
				int kyuSum=0;
				int inSum=0;
				inyoung=nextPermutation(inyoung,9);
				for(int j=0;j<9;j++) {
					if(kyuyoung[j]<inyoung[j])inSum+=kyuyoung[j]+inyoung[j];
					else kyuSum+=kyuyoung[j]+inyoung[j];
				}
				if(kyuSum<inSum)lose++;
				else if(kyuSum>inSum)win++;
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("#"+(a+1)+" "+win+" "+lose);
			System.out.println(sb.toString());
			
			
		}
	}
}
