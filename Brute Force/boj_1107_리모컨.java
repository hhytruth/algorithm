package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_1107_리모컨 {

	static int min=Integer.MAX_VALUE;
	static int N;
	static String channel;
	static int minlen=Integer.MAX_VALUE;
	
	public static void subset(int[] usable,int count,int n,int num) {
		
		int result=Math.min(Math.abs(100-N), Math.abs(N-num));
		String tmp=Integer.toString(num);
		if(N==0&&count==0)result=Math.abs(100-N);
		if(min>result+tmp.length()&&count!=0) {
			min=result+tmp.length();
			channel=tmp;
		}

		if(count==n+1) return;
		
		for(int i=0;i<usable.length;i++) {
			subset(usable,count+1,n,num*10+usable[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		N=Integer.parseInt(input);
		int M=Integer.parseInt(br.readLine());
		boolean[] broken=new boolean[10];
		StringTokenizer st = null;
		if(M>0)st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num=Integer.parseInt(st.nextToken());
			broken[num]=true;
		}
		int minnum=10,maxnum=-1;
		for(int i=0;i<10;i++) {
			if(broken[i])continue;
			if(minnum>i)minnum=i;
			if(maxnum<i)maxnum=i;
		}
		if(M==10) {
			System.out.println(Math.abs(N-100));
			return;
		}
		if(N==100) {
			System.out.println(0);
			return;
		}
		if(M==0) {
			String tmp=Integer.toString(N);
			System.out.println(Math.min(Math.abs(100-N), tmp.length()));
			return;
		}
		
		int[] usable=new int[10-M];
		int idx=0;
		for(int i=0;i<10;i++) {
			if(!broken[i]) {
				usable[idx]=i;
				idx++;
			}
		}
		
		subset(usable,0,input.length(),0);
		System.out.println(Math.min(min, Math.abs(100-N)));
	}

}
