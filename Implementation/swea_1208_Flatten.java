package xml.sax;
import java.io.*;
import java.util.*;

public class swea_1208_Flatten {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int a=0;a<10;a++) {
			int N=Integer.parseInt(br.readLine());
			int[] arr=new int[100];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				Arrays.sort(arr);
				if(arr[99]-arr[0]<=1)break;
				arr[99]--;
				arr[0]++;
			}
			Arrays.sort(arr);
			System.out.println("#"+(a+1)+" "+(arr[99]-arr[0]));
		}
	}

}
