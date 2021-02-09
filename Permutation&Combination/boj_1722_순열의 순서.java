package algorithm;
import java.util.*;
import java.io.*;

public class permutation4{
	static long[] arr;
	static void factorial(int idx,long N) {
		while(idx<N) {
			if(idx==0)arr[idx]=1;
			else {
				arr[idx]=(idx+1)*arr[idx-1];
			}
			idx++;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int problem=Integer.parseInt(st.nextToken());
		int[] numbers=new int[N];
		LinkedList<Integer> list=new LinkedList<>();
		arr=new long[N];
		
		for(int i=0;i<N;i++) {
			numbers[i]=i+1;
			list.add(i+1);
		}
		factorial(0,N);
	
		if(problem==1) {
			long k=Long.parseLong(st.nextToken());
			for(int i=0;i<N-1;i++) {
				long index=k/arr[N-2-i];
				if(k%arr[N-2-i]==0)index--;
				long number=list.get((int) index);
				list.remove((int)index);
				System.out.print(number+" ");
				k-=arr[N-2-i]*index;
			}
			System.out.println(list.remove(0));
			System.out.println();
		}
		else if(problem==2) {
			long count=0;
			for(int i=0;i<N-1;i++) {
				int inputNum=Integer.parseInt(st.nextToken());
				int index2=list.indexOf(inputNum);
				count+=(index2)*arr[N-i-2];
				list.remove(index2);
			}
			System.out.println(count+1);
		}
	}

	

}
