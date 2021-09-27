package atest;
import java.io.*;
import java.util.*;

public class boj_14499_주사위굴리기 {

	static class Dice{
		
		int one;
		int two;
		int three;
		int four;
		int five;
		int six;
		
		public Dice(int o,int t,int th,int f,int fi,int s) {
			one=o;
			two=t;
			three=th;
			four=f;
			five=fi;
			six=s;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[][] map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		Dice dice=new Dice(0,0,0,0,0,0);
		for(int a=0;a<K;a++) {
			int command=Integer.parseInt(st.nextToken());
			int one=dice.one;
			int two=dice.two;
			int three=dice.three;
			int four=dice.four;
			int five=dice.five;
			int six=dice.six;
			
			switch(command) {
			case 1:
				if(y+1>=M)continue;
				y++;
				dice=new Dice(four,two,one,six,five,three);
				break;
			case 2:
				if(y-1<0)continue;
				y--;
				dice=new Dice(three,two,six,one,five,four);
				break;
			case 3:
				if(x-1<0)continue;
				x--;
				dice=new Dice(five,one,three,four,six,two);
				break;
			case 4:
				if(x+1>=N)continue;
				x++;
				dice=new Dice(two,six,three,four,one,five);
				break;
			}
			System.out.println(dice.one);
			if(map[x][y]==0) map[x][y]=dice.six;
			else {
				dice.six=map[x][y];
				map[x][y]=0;
			}
		}
	}

}
