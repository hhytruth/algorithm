package com.exception;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Croatia{

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		Queue<Character> queue=new LinkedList<>();
		
		for(int i=0;i<s.length();i++) {
			queue.add(s.charAt(i));
		}
		
		int sum=0;
		while(!queue.isEmpty()) {
			char first=queue.poll();
			if(queue.isEmpty()) {
				sum++;
				break;
			}
			char second=queue.peek();
			switch(first) {
			case 'c':
				if(second=='='||second=='-') {
					queue.poll();
				}
				break;
			case 'l':
			case 'n':
				if(second=='j') {
					queue.poll();
				}
				break;
			case 'z':
			case 's':
				if(second=='=') {
					queue.poll();
				}
				break;
			case 'd':
				if(second=='z') {
					queue.poll();
					if(!queue.isEmpty()&&queue.peek()=='=') {
						queue.poll();
					}
					else {
						sum++;
					}
				}
				if(second=='-') {
					queue.poll();
				}
				break;
			}
			sum++;
		}
		System.out.println(sum);
	}
	
}
