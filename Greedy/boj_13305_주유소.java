package algorithm.greedy;
import java.util.*;
import java.io.*;

public class boj_13305_주유소 {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		long [] roads=new long[N-1];
		long totalDist=0;	//목적지까지 남은 거리 체크를 위한 변수
		for(int a=0;a<N-1;a++) {
			roads[a]=Long.parseLong(st.nextToken());
			totalDist+=roads[a];
		}
		
		st=new StringTokenizer(br.readLine());
		long[] prices=new long[N];
		for(int a=0;a<N;a++) {
			prices[a]=Long.parseLong(st.nextToken());
		}
		
		int[] nextCheaper=new int[N-1];	//지금 있는 도시보다 뒤에 있는 도시 중 지금 도시와 가장 가깝고 현재 도시보다 주유가가 싼 도시 저장
		for(int a=0;a<N-1;a++) {
			for(int b=a+1;b<N-1;b++) {
				if(prices[b]<prices[a]) {
					nextCheaper[a]=b;
					break;
				}
			}
			if(nextCheaper[a]==0)nextCheaper[a]=-1;	//뒤에 더 싼 도시가 없으면 -1 저장
		}
		
		long result=0;
		int car=0;
		long oil=0;
		while(totalDist>0) {
			if(nextCheaper[car]==-1) {	//뒤에 더 싼 도시가 없을 경우
				oil+=totalDist;
				result+=oil*prices[car];
				car=N-1;
				totalDist=0;
				oil=0;
				continue;
			}
			if(prices[car]>prices[car+1]) {	//바로 뒤 도시가 현재 도시보다 쌀 경우 뒤 도시에 갈 만큼만 주유
				oil+=roads[car];
				result+=oil*prices[car];
				totalDist-=roads[car];
				oil=0;
				car++;
				continue;
			}
			if(prices[car]<prices[car+1]) {	//바로 뒤 도시가 현재 도시보다 비쌀 경우 nextCheaper에 저장된 도시까지 갈 만큼 주유
				for(int i=car;i<nextCheaper[car];i++) {
					oil+=roads[i];
					totalDist-=roads[i];
				}
				result+=oil*prices[car];
				car=nextCheaper[car];
				oil=0;
			}
		}
		System.out.println(result);
	}
}
