package algorithm.greedy;
import java.io.*;
import java.util.*;

public class boj_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String num="";
		int sum=0;
		int tmp=0;
		boolean minus=false;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='0'&&c<='9')num+=c;
			else if(c=='+') {
				tmp+=Integer.parseInt(num);
				num="";
			}
			else {
				tmp+=Integer.parseInt(num);
				if(minus) sum-=tmp;
				else sum+=tmp;
				num="";
				tmp=0;
				minus=true;
			}
		}
		
		tmp+=Integer.parseInt(num);
		if(minus)sum-=tmp;
		else sum+=tmp;
		
		System.out.println(sum);
		
	}

}
