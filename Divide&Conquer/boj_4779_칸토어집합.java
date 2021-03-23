package algorithm.segment;
import java.util.*;
import java.io.*;

public class boj_4779_칸토어집합 {
	static StringBuilder sb;
	public static void recur(int length) {
		if(length==1)sb.append("-");
		else {
			recur(length/3);
			for(int i=0;i<length/3;i++) {
				sb.append(" ");
			}
			recur(length/3);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null) {
			int N=Integer.parseInt(s);
			sb=new StringBuilder();
			recur((int)Math.pow(3, N));
			System.out.println(sb.toString());
		}
	}
	
}
