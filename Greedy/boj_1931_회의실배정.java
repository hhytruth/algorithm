package algorithm.greedy;
import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	int time;
	public Meeting(int start,int end,int time) {
		this.start=start;
		this.end=end;
		this.time=time;
	}
	@Override
	public int compareTo(Meeting o) {
		
		if(this.end==o.end)return this.start-o.start;
		return this.end-o.end;
	}
	
}

public class boj_1931 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		Meeting[] meetings=new Meeting[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			meetings[i]=new Meeting(start,end,end-start);
		}
		
		Arrays.sort(meetings);
		int count=0;
		int curtime=0;
		for(int i=0;i<N;i++) {
			if(curtime<=meetings[i].start) {
				count++;
				curtime=meetings[i].end;
			}
		}
		
		System.out.println(count);
		
	}

}
