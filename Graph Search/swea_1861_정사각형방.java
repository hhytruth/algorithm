package com.exception;
import java.io.*;
import java.util.*;

class Room implements Comparable<Room> {
	int number;
	int route;
	Room(int n){
		number=n;
		route=1;
	}
	
	@Override
	public int compareTo(Room o) {
		if(this.route<o.route)return 1;
		else if(this.route==o.route&&this.number>o.number)
			return 1;
		return -1;
	}

}


public class Square {
	static int result=1;
	static int[][]map;
	static int N;
	
	public static int search(int i,int j) {
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		for(int x=0;x<4;x++) {
			int destx=j+dx[x];
			int desty=i+dy[x];
			if(destx>=0&&desty>=0&&destx<N&&desty<N&&(map[desty][destx]==map[i][j]+1)) {
				search(desty,destx);
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int a=0;a<t;a++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			Room[] arr=new Room[N*N];

			int roomnum=1;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int idx=0;
				while(st.hasMoreTokens()) {
					int num=Integer.parseInt(st.nextToken());
					map[i][idx++]=num;
					Room r=new Room(roomnum);
					arr[roomnum-1]=r;
					roomnum++;
				}		
			}
		
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					result=1;
					arr[map[i][j]-1].route=search(i,j);
				}
			}
			
			Arrays.sort(arr);
			System.out.println("#"+(a+1)+" "+arr[0].number+" "+arr[0].route);
		}
		
	
	}
	

}
 
