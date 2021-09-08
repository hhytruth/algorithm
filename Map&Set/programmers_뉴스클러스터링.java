import java.util.*;

class programmers_뉴스클러스터링 {
   public static int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        for(int i=0;i<str1.length()-1;i++){
            char c1=str1.charAt(i);
            char c2=str1.charAt(i+1);
            if(!((c1>='a'&&c1<='z')||(c1<='Z'&&c1>='A')))continue;
            if(!((c2>='a'&&c2<='z')||(c2<='Z'&&c2>='A')))continue;
            if(c1<='Z'&&c1>='A')c1+='a'-'A';
            if(c2<='Z'&&c2>='A')c2+='a'-'A';
            String s=Character.toString(c1)+Character.toString(c2);
            if(!map1.containsKey(s))map1.put(s,1);
            else{
                int count=map1.get(s);
                map1.put(s,count+1);
            }
          
        }
        for(int i=0;i<str2.length()-1;i++){
            char c1=str2.charAt(i);
            char c2=str2.charAt(i+1);
            if(!((c1>='a'&&c1<='z')||(c1<='Z'&&c1>='A')))continue;
            if(!((c2>='a'&&c2<='z')||(c2<='Z'&&c2>='A')))continue;
            if(c1<='Z'&&c1>='A')c1+='a'-'A';
            if(c2<='Z'&&c2>='A')c2+='a'-'A';
            String s=Character.toString(c1)+Character.toString(c2);
            if(!map2.containsKey(s))map2.put(s,1);
            else{
                int count=map2.get(s);
                map2.put(s,count+1);
            }
        }
        
        int intersect=0,union=0;
        for(Map.Entry<String,Integer> entry:map1.entrySet()){
            String key=entry.getKey();
            int val1=entry.getValue();
            if(!map2.containsKey(key)) union+=val1;
            else{
                int val2=map2.get(key);
                intersect+=Math.min(val1,val2);
                union+=Math.max(val1,val2);
            }
        }    
        for(Map.Entry<String,Integer> entry:map2.entrySet()){
            String key=entry.getKey();
            int val2=entry.getValue();
            if(!map1.containsKey(key)) union+=val2;
        }
        if(union==0) return 65536;
        float jacard=(float)intersect/(float)union*65536;
        answer=(int)Math.floor(jacard);
        
        return answer;
    }
}
