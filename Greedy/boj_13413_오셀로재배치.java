package com.exception;
import java.io.*;
import java.util.*;
//뒤집기보다 위치를 바꿔주는 것이 더 유리

public class boj_13413_오셀로재배치 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			int N=Integer.parseInt(br.readLine());
			String init=br.readLine();
			String goal=br.readLine();
			int initB=0,goalB=0;
			int move=0;
			
			for(int i=0;i<N;i++) {	//black 세기
				if(init.charAt(i)=='B')initB++;
				if(goal.charAt(i)=='B')goalB++;
			}
			
			int idx=0;
			StringBuilder sb=new StringBuilder(init);
			while(move<Math.abs(initB-goalB)) {	//흰검 개수 맞춰주기(뒤집기)
				if(init.charAt(idx)!=goal.charAt(idx)) {
					sb.setCharAt(idx, goal.charAt(idx));				
					move++;
				}
				idx++;
			}
			init=sb.toString();
			
			int diff=0;	//색이 다른 말의 개수
			for(int i=0;i<N;i++) {
				if(init.charAt(i)!=goal.charAt(i))diff++;
			}
			//위치 바꾸기
			move+=diff/2;	//서로 바꿔주기 때문에 2개의 말을 바꾸는 것과 동일-> 나누기 2
			System.out.println(move);
			
		}
		
	}
}
