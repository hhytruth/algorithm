package algorithm.stack;
import java.io.*;
import java.util.*;

public class boj_6549_히스토그램에서가장큰직사각형 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Long[]> stack;
		while(true) {
			st=new StringTokenizer(br.readLine());
			long n=Long.parseLong(st.nextToken());
			if(n==0)break;
			stack=new Stack<>();
			long max=0;
			for(long i=0;i<n;i++) {
				long h=Integer.parseInt(st.nextToken());
				
				long startidx=i;
				while(!stack.isEmpty()&&(long)stack.peek()[0]>h) {
					Long[] rectangle=stack.pop();
					long area=(long)rectangle[0]*(long)(i-rectangle[1]);
					if(max<area)max=area;
					startidx=rectangle[1];
				}
				
				
				if(stack.isEmpty()||(long)stack.peek()[0]<h){
					stack.add(new Long[] {h,startidx});
				}
				else if((long)stack.peek()[0]<h) continue;
			}
			
			while(!stack.isEmpty()) {
				Long[] rectangle=stack.pop();
				long area=(long)(n-rectangle[1])*(long)rectangle[0];
				if(max<area)max=area;
			}
			
			System.out.println(max);
			
		}
		
		
	}

}
