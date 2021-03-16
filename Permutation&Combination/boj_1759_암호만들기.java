package swing;
import java.io.*;
import java.util.*;


public class boj_1759_암호만들기 {
	static int L;
	static Stack<String> slist;
	public static void comb(char[] arr,char[] result,boolean[] visited,int n,int r,int depth,int vowel,int consonant,int idx) {
		if(r==0) {
			if(consonant>=2&&vowel>=1) {
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<L;i++) {
					sb.append(result[i]);
				}
				slist.add(sb.toString());
			}
			return;
		}
		if(depth==n)return;
		visited[depth]=false;
		comb(arr,result,visited,n,r,depth+1,vowel,consonant,idx);
		
		visited[depth]=true;
		result[idx]=arr[depth];
		if(arr[depth]=='a'||arr[depth]=='i'||arr[depth]=='u'||arr[depth]=='e'||arr[depth]=='o') {
			vowel++;
		}
		else consonant++;
		comb(arr,result,visited,n,r-1,depth+1,vowel,consonant,idx+1);
		
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		L=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		boolean[] visited=new boolean[C];
		char[] result=new char[C];
		char[] arr=new char[C];
		slist=new Stack<>();
		for(int i=0;i<C;i++) {
			char c=st.nextToken().charAt(0);
			arr[i]=c;
		}
		
		Arrays.sort(arr);
		comb(arr,result,visited,C,L,0,0,0,0);
		while(!slist.isEmpty()) {
			System.out.println(slist.pop());
		}
	}

}
