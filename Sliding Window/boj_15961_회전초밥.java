package swing;

import java.util.*;
import java.io.*;

public class boj_15961_회전초밥 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int[] sushis=new int[N];
		for(int i=0;i<N;i++) {
			int sushi=Integer.parseInt(br.readLine());
			sushis[i]=sushi;
		}
		int[] eat=new int[d+1];
		Queue<Integer> queue=new LinkedList<>();
		int max=0,start=0,end=-1;
		int eatCount=0;
		for(int i=0;i<k;i++) {
			queue.add(sushis[i]);
			end++;
			if(eat[sushis[i]]==0) eatCount++;
			eat[sushis[i]]++;
		}
		if(eat[c]==0)max=eatCount+1;
		else max=eatCount;
		
		for(int i=1;i<N;i++) {
			start++;
			end++;
			if(end==N)end=0;
			int tmp=queue.poll();
			queue.add(sushis[end]);
			if(--eat[tmp]==0)eatCount--;
			if(eat[sushis[end]]==0)eatCount++;
			eat[sushis[end]]++;
			if(max<=eatCount) {
				if(eat[c]==0)max=eatCount+1;
				else max=eatCount;
			}
		}
		
		System.out.println(max);
		
	}

}
