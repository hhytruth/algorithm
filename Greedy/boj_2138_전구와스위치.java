package algorithm.greedy;
import java.io.*;
import java.util.*;

public class boj_2138_전구와스위치 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder start=new StringBuilder(br.readLine());
		String tmp=start.toString();
		String goal=br.readLine();
		int push=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=1;i<N-1;i++) {
			if(start.charAt(i-1)!=goal.charAt(i-1)) {
				if(start.charAt(i-1)=='0')start.setCharAt(i-1, '1');
				else start.setCharAt(i-1, '0');
				
				if(start.charAt(i)=='0')start.setCharAt(i, '1');
				else start.setCharAt(i, '0');
				
				if(start.charAt(i+1)=='0')start.setCharAt(i+1, '1');
				else start.setCharAt(i+1, '0');
				
				push++;
			}
		}
		
		if(start.charAt(N-1)!=goal.charAt(N-1)&&start.charAt(N-2)!=goal.charAt(N-2)){
			push++;
			min=push;
		}
		else if(start.charAt(N-1)==goal.charAt(N-1)&&start.charAt(N-2)==goal.charAt(N-2)) {
			min=push;
		}
		
		push=1;
		start=new StringBuilder(tmp);
		
		if(start.charAt(0)=='0')start.setCharAt(0, '1');
		else start.setCharAt(0, '0');
		
		if(start.charAt(1)=='0')start.setCharAt(1, '1');
		else start.setCharAt(1, '0');
		
		for(int i=1;i<N-1;i++) {
			if(start.charAt(i-1)!=goal.charAt(i-1)) {
				if(start.charAt(i-1)=='0')start.setCharAt(i-1, '1');
				else start.setCharAt(i-1, '0');
				
				if(start.charAt(i)=='0')start.setCharAt(i, '1');
				else start.setCharAt(i, '0');
				
				if(start.charAt(i+1)=='0')start.setCharAt(i+1, '1');
				else start.setCharAt(i+1, '0');
				
				push++;
			}
		}
		
		if(start.charAt(N-1)!=goal.charAt(N-1)&&start.charAt(N-2)!=goal.charAt(N-2)){
			push++;
			if(push<min)min=push;
		}
		else if(start.charAt(N-1)==goal.charAt(N-1)&&start.charAt(N-2)==goal.charAt(N-2)) {
			if(push<min)min=push;
		}
		
		if(min!=Integer.MAX_VALUE)System.out.println(min);
		else System.out.println(-1);
	}

}
