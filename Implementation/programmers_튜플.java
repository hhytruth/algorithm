import java.util.*;

class programmers_튜플 {
    public static int[] solution(String s) {
        int[] answer={};
        String[] tmp=s.split("\\{");
        Arrays.sort(tmp,new Comparator<String>() {
        	@Override
        	public int compare(String s1,String s2) {
        		return s1.length()-s2.length();
        	}
        });
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[100001];
        for(String str:tmp){
            str=str.replace("}","");
            if(str.equals(""))continue;
            String[] numbers=str.split(",");
            for(String number:numbers) {
            	int num=Integer.parseInt(number);
            	if(!visited[num]) {
            		visited[num]=true;
            		list.add(num);
            		break;
            	}
            }
            
        }
        answer=new int[list.size()];
        for(int i=0;i<list.size();i++) {
        	answer[i]=list.get(i);
        }
        return answer;
    }
	
}
