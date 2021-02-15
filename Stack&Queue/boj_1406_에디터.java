package algorithm.stack;
import java.io.*;
import java.util.*;

public class boj_1406 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		Stack<Character> afterCursor=new Stack<>();	//beforeCursor와 순서가 반대(가장 위가 커서 바로 다음 문자)
		Stack<Character> beforeCursor=new Stack<>();
		int M=Integer.parseInt(br.readLine());
		
		for(int i=0;i<s.length();i++) {
			beforeCursor.add(s.charAt(i));
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			char command=st.nextToken().charAt(0);
			switch(command) {
			case 'L':
				if(!beforeCursor.isEmpty()) {
					afterCursor.add(beforeCursor.pop());
				}
				break;
			case 'D':
				if(!afterCursor.isEmpty()) beforeCursor.add(afterCursor.pop());
				break;
			case 'B':
				if(!beforeCursor.isEmpty()) beforeCursor.pop();
				break;
			case 'P':
				char c=st.nextToken().charAt(0);
				beforeCursor.add(c);
				break;
			}
			
		}
		StringBuilder sb=new StringBuilder();	//stringbuilder를 써야 시간초과가 안남
		Iterator iter=beforeCursor.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		ListIterator iter2=afterCursor.listIterator(afterCursor.size());
		while(iter2.hasPrevious()) {
			sb.append(iter2.previous());
		}
		System.out.println(sb.toString());
	}

}
