package swing;
import java.io.*;
import java.util.*;

public class swea_5607_조합 {

	public static long pow(long a,int b) {
		if(b==0)return 1;
		if(b==1) return a;
		if(b%2==0) {
			long tmp=pow(a,b/2);
			return (tmp*tmp)%1234567891;
		}
		long tmp=pow(a,b-1)%1234567891;
		return (tmp*a)%1234567891;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int a=0;a<T;a++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			
			long[] fact=new long[N+1];
			fact[1]=1;
			for(int i=2;i<=N;i++) {
				fact[i]=(fact[i-1]*i)%1234567891;
			}
			long bottom=(fact[R]*fact[N-R])%1234567891;
			bottom=pow(bottom,1234567891-2);
			System.out.println("#"+(a+1)+" "+(fact[N]*bottom)%1234567891);
		}
	}

}
