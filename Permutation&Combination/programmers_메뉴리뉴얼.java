import java.util.*;
import java.io.*;
import java.util.Map.Entry;

class programmers_메뉴리뉴얼 {
    static Map<String,Integer> map=new HashMap<>();
    static int[] maxorder=new int[11];
    public static void powerset(String s,int depth,String result,int[] course){
        if(depth==s.length()){
            if(result.length()<2)return;
            int len=result.length();
            if(!Arrays.stream(course).anyMatch(x->x==len)) return;
            if(map.containsKey(result)){
                int cnt=map.get(result);
                map.put(result,cnt+1);
                if(cnt+1>maxorder[result.length()])maxorder[result.length()]=cnt+1;
            }
            else {
                map.put(result,1);
                if(1>maxorder[result.length()])maxorder[result.length()]=1;
            }

            return;
        }
        
        powerset(s,depth+1,result,course);
        result+=Character.toString(s.charAt(depth));
        powerset(s,depth+1,result,course);
    }   
    
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> list=new ArrayList<>();
        
        for(String order:orders) {
        	char[] arr=order.toCharArray();
        	Arrays.sort(arr);
        	powerset(new String(arr),0,"",course);
        }
        
        for(Entry<String,Integer> entry:map.entrySet()){
            String key=entry.getKey();
            if(maxorder[key.length()]==entry.getValue()&&entry.getValue()>1) list.add(key);
        }
        
        Collections.sort(list);
        answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        for(String s:answer)System.out.println(s);
        return answer;
    }
}
