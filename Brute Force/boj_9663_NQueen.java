package algorithm.bruteforce;
import java.io.*;
import java.util.*;

public class boj_9663_NQueen {

	static int[][] map;
	static int N;
	static int answer=0;
	
	public static void recur(int[][] selected,int count,boolean[] rowcheck,boolean[] colcheck) {
		
		if(count==N) {
			answer++;
			return;
		}
		
		
		for(int j=0;j<N;j++) {
			if(rowcheck[count])break;
			if(colcheck[j])continue;
			boolean ok=true;
			for(int k=0;k<count;k++) {
				int selectedx=selected[k][1];
				int selectedy=selected[k][0];
				if(Math.abs(selectedx-j)==Math.abs(selectedy-count)) {
					ok=false;
					break;
				}
			}
			if(ok) {
				rowcheck[count]=true;
				colcheck[j]=true;
				selected[count][0]=count;
				selected[count][1]=j;
				recur(selected,count+1,rowcheck,colcheck);
				rowcheck[count]=false;
				colcheck[j]=false;
			}
		
	}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		int[][] selected=new int[N][2];
		boolean[] rowcheck=new boolean[N];
		boolean[] colcheck=new boolean[N];
		recur(selected,0,rowcheck,colcheck);
		System.out.println(answer);
	}

}
