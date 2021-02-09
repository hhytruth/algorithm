package com.off.day4.sol;
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Josephus {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		LinkedList<Integer> list=new LinkedList<>();
		LinkedList<Integer> result=new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			list.add(i+1);
		}
		
		int idx=K-1;
		while(!list.isEmpty()) {
			result.add(list.remove(idx));
			idx+=K-1;
			if(list.isEmpty())break;
			if(idx>=list.size()) {
				idx%=list.size();
			}
		}
		System.out.print("<");
		for(int i=0;i<N-1;i++) {
			System.out.print(result.get(i)+", ");
		}
		System.out.println(result.get(N-1)+">");
	}
}

