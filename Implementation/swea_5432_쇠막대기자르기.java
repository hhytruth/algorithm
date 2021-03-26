package com.off.day4.sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class swea_5432_쇠막대기자르기 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(bf.readLine());
		for(int a=0;a<T;a++) {
			String s=bf.readLine();
			int laser=0;
			int sum=0;
			int tmp=0;
			for(int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				if(i+1<s.length()&&c=='('&&s.charAt(i+1)==')') {
					sum+=tmp;
				}
				else if(i+1<s.length()&&c=='('&&s.charAt(i+1)=='(') {
					tmp++;
				}
				else if(i-1>=0&&c==')'&&s.charAt(i-1)==')') {
					sum++;
					tmp--;
				}
			}
			System.out.println("#"+(a+1)+" "+sum);
		}
	}
}

