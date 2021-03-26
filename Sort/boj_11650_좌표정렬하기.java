package algorithm.sort;

import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
	int first;
	int second;
	public Pair(int f,int s) {
		first=f;
		second=s;
	}
	
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if(this.first==o.first)return this.second-o.second;
		return this.first-o.first;
	}
	
}

public class boj_11650_좌표정렬하기 {

	public static void main(String[] args) {
		int N,x,y;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		PriorityQueue<Pair> pq=new PriorityQueue<>();

		for(int i=0;i<N;i++) {
			x=sc.nextInt();
			y=sc.nextInt();
			Pair p=new Pair(x,y);
			pq.add(p);
			
		}
		for(int i=0;i<N;i++) {
			Pair p=pq.poll();
			System.out.println(p.first+" "+p.second);
		}
	}
	
	
	
}
