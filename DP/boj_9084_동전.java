package swing;
import java.io.*;
import java.util.*;

public class boj_9084_동전 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[] coins=new int[20];
			for(int i=0;i<N;i++) {
				coins[i]=Integer.parseInt(st.nextToken());
			}
			int M=Integer.parseInt(br.readLine()); 
			int[] result=new int[10001];
			
			for(int i=0;i<N;i++) {
				result[coins[i]]++;
				for(int j=coins[i]+1;j<=M;j++) {
					result[j]=result[j]+result[j-coins[i]];
				}
			}
			System.out.println(result[M]);
		}
	}

}
