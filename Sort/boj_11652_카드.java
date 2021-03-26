package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_11652_카드 {

	public static void main(String[] args) {
		
		int N;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		ArrayList<Long> list=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			long input=sc.nextLong();
			list.add(input);
		}
		Collections.sort(list);
		int count=0;
		int maxcount=0;
		long result=list.get(0);
		long cur=list.get(0);
		for(long l:list) {
			if(cur==l) {
				count++;
				if(count>maxcount) {
					maxcount=count;
					result=l;
				}
				
			}
			else {
				count=1;
				cur=l;
			}
		}
		System.out.println(result);
		
	}	
}
