package xml.sax;
import java.util.*;
import java.io.*;

public class boj_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int a=0;a<t;a++) {
			int n=Integer.parseInt(br.readLine());
			int[][] csarr=new int[n][2];
			StringTokenizer st=new StringTokenizer(br.readLine());
			int homex=Integer.parseInt(st.nextToken());
			int homey=Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				int csx=Integer.parseInt(st.nextToken());
				int csy=Integer.parseInt(st.nextToken());
				csarr[i]=new int[] {csy,csx};
			}
			st=new StringTokenizer(br.readLine());
			int rockx=Integer.parseInt(st.nextToken());
			int rocky=Integer.parseInt(st.nextToken());
			boolean found=false;
			int curx=homex;
			int cury=homey;
			Queue<Integer[]> queue=new LinkedList<>();
			queue.add(new Integer[] {cury,curx});
			boolean[] visited=new boolean[n];
			
			while(!queue.isEmpty()) {
				Integer[] cur=queue.poll();
				curx=cur[1];
				cury=cur[0];
				
				if((Math.abs(curx-rockx)+Math.abs(cury-rocky))<=1000) {
					System.out.println("happy");
					found=true;
					break;
				}
				
				for(int i=0;i<n;i++) {
					if(!visited[i]&&(Math.abs(curx-csarr[i][1])+Math.abs(cury-csarr[i][0]))<=1000){
						queue.add(new Integer[] {csarr[i][0],csarr[i][1]});
						visited[i]=true;
					}
				}
			}
			
			if(!found)System.out.println("sad");
		}
	
	}
}
