package algorithm.greedy;
import java.io.*;
import java.util.*;

public class boj_1439 {	
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int zero=0,one=0;
		int continueing=-1;
		for(int i=0;i<s.length();i++) {
			char cur=s.charAt(i);
			if(continueing==cur)continue;
			if(cur=='0')zero++;
			else if(cur=='1')one++;
			continueing=cur;
		}
		
		System.out.println(Math.min(zero, one));
	}
	
}
