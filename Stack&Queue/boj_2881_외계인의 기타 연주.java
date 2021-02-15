package algorithm.stack;
import java.util.*;
import java.io.*;

public class boj_2841 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		ArrayList<Stack<Integer>> guitar=new ArrayList<Stack<Integer>>();
		for(int i=0;i<N;i++) {
			Stack<Integer> stack = new Stack<>();
			guitar.add(stack);
		}
		int move=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int line=Integer.parseInt(st.nextToken());
			int fret=Integer.parseInt(st.nextToken());
			while(!guitar.get(line-1).isEmpty()) {
				if(guitar.get(line-1).peek()<fret) {
					move++;
					guitar.get(line-1).push(fret);
					break;
				}
				else if(guitar.get(line-1).peek()==fret) break;
				else {
					guitar.get(line-1).pop();
					move++;
				}
				
			}
			if(guitar.get(line-1).isEmpty()) {
				move++;
				guitar.get(line-1).push(fret);
			}
		}
		System.out.println(move);
		
	}
}
