package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_1527_금민수의개수 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(0);
		int count=0;
		
		for(int i=0;!queue.isEmpty();i++) {
			int size=queue.size();
			for(int j=0;j<size;j++) {
				int number=queue.poll();
				int nextNumber=(int)(number+4*Math.pow(10, i));
				if(nextNumber>=A&&nextNumber<=B)count++;
				if(nextNumber<=B)queue.offer(nextNumber);
				
				nextNumber=(int)(number+7*Math.pow(10, i));
				if(nextNumber>=A&&nextNumber<=B)count++;
				if(nextNumber<=B)queue.offer(nextNumber);
			}
			
		}
		
		System.out.println(count);
	}

}
