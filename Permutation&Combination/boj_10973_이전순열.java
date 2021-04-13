package swing;
import java.util.*;
import java.io.*;

public class boj_10973_이전순열 {

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int prev=arr[0];
		boolean exist=false;
		for(int i=1;i<N;i++) {
			if(prev>=arr[i]) {
				exist=true;
				break;
			}
			prev=arr[i];
		}
		if(!exist)System.out.println(-1);
		else {
			prev=N-1;
			int[] result=new int[N];
			for(int i=N-2;i>=0;i--) {
				if(arr[prev]<arr[i]) {
					int maxidx=prev;
					for(int j=prev;j<N;j++) {
						if(arr[maxidx]<arr[j]&&arr[i]>arr[j])maxidx=j;
					}
					int tmp=arr[maxidx];
					arr[maxidx]=arr[i];
					arr[i]=tmp;
					
					Arrays.sort(arr,prev , N);
					for(int j=0;j<prev;j++) {
						result[j]=arr[j];
					}
					for(int j=prev;j<N;j++) {
						result[j]=arr[N-j+prev-1];
					}
					break;
				}
				prev--;
			}
			for(int i=0;i<N;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
		//5 4  3 1 2		
		//1 2 4 3 5
	}

}
