package algorithm.dp;
import java.util.*;
import java.io.*;

public class boj_1003_피보나치함수 {
	
	//fibonacci(n)=fibonacci(n-1)+fibonacci(n-2)이므로 0과 1출력 횟수 점화식도 이와 같다
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int N=Integer.parseInt(br.readLine());
			int[] zero=new int[N+1];
			int[] one=new int[N+1];
			zero[0]=1;
			one[0]=0;
			if(N>=1) {
				zero[1]=0;
				one[1]=1;
			}
			if(N>1) {
				for(int i=2;i<=N;i++) {
					zero[i]=zero[i-1]+zero[i-2];
					one[i]=one[i-1]+one[i-2];
				}	
			}
			
			
			System.out.println(zero[N]+" "+one[N]);
		}
	}

}
