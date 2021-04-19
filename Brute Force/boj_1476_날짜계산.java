package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_1476_날짜계산 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int E=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int lcm=19*28*15;
		if(E==15&&S==28&&M==19)System.out.println(7980);
		else {
			for(int i=0;i<lcm;i++) {
				if(i%15==E%15&&i%28==S%28&&i%19==M%19) {
					System.out.println(i);
					break;
				}
			}
		}
		
	}

}
