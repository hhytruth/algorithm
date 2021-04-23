package algorithm.graph;
import java.io.*;
import java.util.*;

public class boj_11780_플로이드2 {
	
	static int count=0;
	static int[][] route=new int[101][101];

	
	static void countCity(int i,int j) {
		if(route[i][j]!=10000001) {
			count++;
			countCity(i,route[i][j]);
			countCity(route[i][j],j);
		}
	}
	
	static void findRoute(int i,int j) {
		if(route[i][j]!=10000001) {
			findRoute(i,route[i][j]);
			System.out.print(route[i][j]+" ");
			findRoute(route[i][j],j);
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[][] matrix=new int[101][101];
		for(int i=0;i<m;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(matrix[a][b]>0&&c<matrix[a][b]) matrix[a][b]=c;
			else if(matrix[a][b]==0) matrix[a][b]=c;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(matrix[i][j]==0)matrix[i][j]=10000001;
				route[i][j]=10000001;
			}
		}
				
		for(int via=1;via<=n;via++) {
			for(int from=1;from<=n;from++) {
				if(from==via)continue;
				for(int to=1;to<=n;to++) {
					if(from==to||to==via)continue;
					if(matrix[from][to]>matrix[from][via]+matrix[via][to]) {
						matrix[from][to]=matrix[from][via]+matrix[via][to];
						route[from][to]=via;
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(matrix[i][j]==10000001)System.out.print(0+" ");
				else System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(matrix[i][j]==10000001||i==j)System.out.println(0);
				else {
					count=2;
					countCity(i,j);
					System.out.print(count+" "+i+" ");
					findRoute(i,j);
					System.out.println(j);
				}
			}
		}
		
	}

}
