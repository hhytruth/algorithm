import java.util.*;

class programmers_캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache=new ArrayList<>();
        for(String city:cities){
            city=city.toUpperCase();
            boolean contains=false;
            for(int i=0;i<cache.size();i++){
                if(city.equals(cache.get(i))){
                    contains=true;
                    cache.remove(i);
                    cache.add(city);
                    break;
                }
            }
            if(contains)answer++;
            else{
                if(cacheSize==0){
                    answer+=5;
                    continue;
                }
                if(cache.size()>=cacheSize) cache.remove(0);
                cache.add(city);
                answer+=5;
            }
        }
        return answer;
    }
}
