import java.util.*;
class programmers_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(priorities[i]);
        }
        while(!queue.isEmpty()){
            if(location==0){
                int cur=queue.poll();
                for(int doc:queue){
                    if(cur<doc){
                        queue.add(cur);
                        location=queue.size()-1;
                        break;
                    }
                }
                if(location==0) return answer;
            }
            else{
                int cur=queue.poll();
                boolean printed=true;
                for(int doc:queue){
                    if(cur<doc){
                        queue.add(cur);
                        printed=false;
                        break;
                    }
                }
                if(printed)answer++;
                location--;
            }
        }
        return answer;
    }
}
