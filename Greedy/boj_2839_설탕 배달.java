package com.exception;
import java.io.*;
import java.util.*;


public class boj_2839_설탕 배달 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int five=N/5;
		int remain=N-5*five;
		int three=remain/3;
		while(five>0) {
			if(remain%3==0)break;
			five--;
			remain+=5;
			three=remain/3;
			
		}
		if(remain%3==0)System.out.println(five+three);
		else{
			three=N/3;
			if(N%3!=0)System.out.println(-1);
			else System.out.println(three);
		}
		
	
		
	
	}
	

}
