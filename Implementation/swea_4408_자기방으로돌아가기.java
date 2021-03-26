package xml.sax;
import java.io.*;
import java.util.*;

public class swea_4408_자기방으로돌아가기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int a=0;a<T;a++) {
			int N=Integer.parseInt(br.readLine().trim());
			int[] corridor=new int[200];
			int max=0;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int curroom=Integer.parseInt(st.nextToken());
				int destroom=Integer.parseInt(st.nextToken());
				if(curroom%2==0)curroom=curroom/2-1;
				else curroom=curroom/2;
				if(destroom%2==0)destroom=destroom/2-1;
				else destroom=destroom/2;
				if(destroom<curroom) {
					int temp=destroom;
					destroom=curroom;
					curroom=temp;
				}
				for(int j=curroom;j<=destroom;j++) {
					corridor[j]++;
					if(max<corridor[j])max=corridor[j];
				}
				
			}
			System.out.println("#"+(a+1)+" "+max);

		}
		
	}

}
