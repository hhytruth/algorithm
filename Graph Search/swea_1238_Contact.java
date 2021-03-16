package swing;
import java.io.*;
import java.util.*;


public class swea_1238_Contact {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int a=0;a<10;a++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int size=Integer.parseInt(st.nextToken());
			int start=Integer.parseInt(st.nextToken());
			boolean[][] contacts=new boolean[101][101];
			boolean[] visited=new boolean[101];
			String s=br.readLine();
			st=new StringTokenizer(s);
			while(st.hasMoreTokens()) {
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				contacts[from][to]=true;
			}
			
			Queue<Integer> queue=new LinkedList<>();
			queue.add(start);
			int[] depths=new int[101];
			int depth=1;
			int levelCnt=1;
			while(!queue.isEmpty()) {
				int tmp=0;
				for(int x=0;x<levelCnt;x++) {
					int num=queue.poll();
					for(int i=0;i<101;i++) {
						if(contacts[num][i]&&!visited[i]) {
							visited[i]=true;
							queue.add(i);
							depths[i]=depth;
							tmp++;
						}
					}
				}
				levelCnt=tmp;
				
				depth++;
			}
				
			int result=0;
			int maxDepth=0;
			for(int i=0;i<101;i++) {
				if(depths[i]>=maxDepth) {
					maxDepth=depths[i];
					result=i;
				}
			}
			System.out.println("#"+(a+1)+" "+result);
		}		
	}

}
