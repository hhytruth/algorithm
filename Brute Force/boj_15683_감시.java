package atest;
import java.util.*;
import java.io.*;

public class boj_15683_감시 {

	public static ArrayList<Integer[]> cctvs=new ArrayList<>();
	public static int N,M;
	public static int min=Integer.MAX_VALUE;
	
	public static void cctv(String[][] map, int depth) {
		
		if(depth>=cctvs.size()) {
			String[][] map2=new String[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map2[i][j]=map[i][j];
				}
			}
			
			for(Integer[] xy:cctvs) {
				String direction=map[xy[0]][xy[1]];				
				if(direction.contains("L")) {
					for(int i=xy[1]-1;i>=0;i--) {
						if(map2[xy[0]][i].equals("0"))
							map2[xy[0]][i]="#";
						else if(map2[xy[0]][i].equals("6")) break;
					}
				}
				if(direction.contains("R")) {
					for(int i=xy[1]+1;i<M;i++) {
						if(map2[xy[0]][i].equals("0"))
							map2[xy[0]][i]="#";
						else if(map2[xy[0]][i].equals("6")) break;
					}
				}
				if(direction.contains("U")) {
					for(int i=xy[0]-1;i>=0;i--) {
						if(map2[i][xy[1]].equals("0"))
							map2[i][xy[1]]="#";
						else if(map2[i][xy[1]].equals("6")) break;
					}
				}
				if(direction.contains("D")) {
					for(int i=xy[0]+1;i<N;i++) {
						if(map2[i][xy[1]].equals("0"))
							map2[i][xy[1]]="#";
						else if(map2[i][xy[1]].equals("6")) break;
					}
				}	
			}
			
			int invisible=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map2[i][j].equals("0")) invisible++;
				}
			}
			if(min>invisible)min=invisible;
			return;
		}
		Integer[] xy=cctvs.get(depth);
		String camera=map[xy[0]][xy[1]];
		if(camera.equals("1")||camera.equals("R")||camera.equals("L")||camera.equals("U")||camera.equals("D")) {
			map[xy[0]][xy[1]]="R";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="D";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="L";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="U";
			cctv(map,depth+1);
		}
		else if(camera.equals("2")||camera.equals("UD")||camera.equals("LR")) {
			map[xy[0]][xy[1]]="UD";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="LR";
			cctv(map,depth+1);
		}
		else if(camera.equals("3")||camera.length()==2) {
			map[xy[0]][xy[1]]="UR";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="RD";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="DL";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="LU";
			cctv(map,depth+1);
		}
		else if(camera.equals("4")||camera.length()==3) {
			map[xy[0]][xy[1]]="LUR";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="URD";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="RDL";
			cctv(map,depth+1);
			map[xy[0]][xy[1]]="DLU";
			cctv(map,depth+1);
		}
		else if(camera.equals("5")||camera.length()==4) {
			map[xy[0]][xy[1]]="LURD";
			cctv(map,depth+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		String[][] map=new String[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=st.nextToken();
				if(map[i][j].charAt(0)>='1'&&map[i][j].charAt(0)<='5')
					cctvs.add(new Integer[] {i,j});
			}
		}
		
		cctv(map,0);
		System.out.println(min);	
	}

}
