package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] matrix=new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			matrix[A][B]=1;
			matrix[B][A]=1;
		}
		
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				if(matrix[i][j]==0)matrix[i][j]=500001;
			}
		}
		
		for(int via=1;via<=N;via++) {
			for(int from=1;from<=N;from++) {
				if(via==from)continue;
				for(int to=1;to<=N;to++) {
					if(via==to||from==to)continue;
					if(matrix[from][via]+matrix[via][to]<matrix[from][to]) {
						matrix[from][to]=matrix[from][via]+matrix[via][to];
					}
				}
			}
		}
		
		int min=Integer.MAX_VALUE,idx=0;
		for(int i=1;i<=N;i++) {
			int bacon=0;
			for(int j=1;j<=N;j++) {
				if(i!=j) bacon+=matrix[i][j];
			}
			if(min>bacon) {
				min=bacon;
				idx=i;
			}
		}
		
		System.out.println(idx);
	}

}
