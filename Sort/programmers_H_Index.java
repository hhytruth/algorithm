import java.util.*;
class programmers_H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=citations.length;i>0;i--){
            if(i<=citations[citations.length-i]){
                if(i==citations.length)return i;
                if(citations[citations.length-i-1]<=i)return i;
            }
        }
        return answer;
    }
}
