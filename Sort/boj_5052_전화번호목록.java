package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class boj_5052_전화번호목록{
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int a=0;a<t;a++) {
			int n=sc.nextInt();
			String[] list=new String[n];
			int size=0;
			boolean okay=true;
			for(int i=0;i<n;i++) {
				String number=sc.next();	
				list[i]=number;				
			}
			Arrays.sort(list);
			for(int i=0;i<list.length-1;i++) {
				if(list[i].length()<list[i+1].length()&&list[i+1].subSequence(0, list[i].length()).equals(list[i])) {
					System.out.println("NO");
					okay=false;
					break;
				}
			}
		
			
			if(okay==true)System.out.println("YES");
		}
	}
	
}
