package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_11403_경로찾기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] matrix=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int via=0;via<N;via++) {
			for(int from=0;from<N;from++) {
				for(int to=0;to<N;to++) {
					if(matrix[from][via]==1&&matrix[via][to]==1) {
						matrix[from][to]=1;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
