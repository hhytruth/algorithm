package algorithm.bruteforce;
import java.io.*;
import java.util.*;

class state{
	int A,B,C;
	state(int a,int b,int c){
		A=a;
		B=b;
		C=c;
	}
}

public class boj_2251_물통 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		boolean[][][] visited=new boolean[A+1][B+1][C+1];
		ArrayList<Integer> waters=new ArrayList<>();
		boolean[] resultCheck=new boolean[C+1];
		Queue<state> queue=new LinkedList<>();
		queue.add(new state(0,0,C));
	
		while(!queue.isEmpty()) {
			state s=queue.poll();
			if(s.A==0&&!resultCheck[s.C]) {
				resultCheck[s.C]=true;
				waters.add(s.C);
			}
			int nexta,nextb,nextc;
			nexta=s.A-Math.min(B-s.B, s.A);
			nextb=s.B+Math.min(B-s.B, s.A);
			nextc=s.C;
			if(!visited[nexta][nextb][nextc]) {
				visited[nexta][nextb][nextc]=true;
				queue.add(new state(nexta,nextb,nextc));
			}
			
			nexta=s.A-Math.min(C-s.C, s.A);
			nextb=s.B;
			nextc=s.C+Math.min(C-s.C, s.A);
			if(!visited[nexta][nextb][nextc]) {
				visited[nexta][nextb][nextc]=true;
				queue.add(new state(nexta,nextb,nextc));
			}
			
			nexta=s.A+Math.min(A-s.A, s.B);
			nextb=s.B-Math.min(A-s.A, s.B);
			nextc=s.C;
			if(!visited[nexta][nextb][nextc]) {
				visited[nexta][nextb][nextc]=true;
				queue.add(new state(nexta,nextb,nextc));
			}
			
			nexta=s.A;
			nextb=s.B-Math.min(C-s.C, s.B);
			nextc=s.C+Math.min(C-s.C, s.B);
			if(!visited[nexta][nextb][nextc]) {
				visited[nexta][nextb][nextc]=true;
				queue.add(new state(nexta,nextb,nextc));
			}
			
			nexta=s.A+Math.min(A-s.A, s.C);
			nextb=s.B;
			nextc=s.C-Math.min(A-s.A, s.C);
			if(!visited[nexta][nextb][nextc]) {
				visited[nexta][nextb][nextc]=true;
				queue.add(new state(nexta,nextb,nextc));
			}
			
			nexta=s.A;
			nextb=s.B+Math.min(B-s.B, s.C);
			nextc=s.C-Math.min(B-s.B, s.C);
			if(!visited[nexta][nextb][nextc]) {
				visited[nexta][nextb][nextc]=true;
				queue.add(new state(nexta,nextb,nextc));
			}
		}
		
		Collections.sort(waters);
		for(int i=0;i<waters.size();i++) {
			System.out.print(waters.get(i)+" ");
		}
		System.out.println();
	}

}
