import java.util.*;
class programmers_기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
	        int[] answer;
	        Stack<Integer> days=new Stack<>();
	        ArrayList<Integer> result=new ArrayList<>(); 
	        int count=1;
	        for(int i=0;i<progresses.length;i++){
	            if((100-progresses[i])%speeds[i]==0){
	                if(days.isEmpty()||days.peek()<(100-progresses[i])/speeds[i]) {
	                	if(!days.isEmpty())result.add(count);
	                    days.add((100-progresses[i])/speeds[i]);
	                    count=1;
	                }
	                else count++;
	            }
	            else {
	                if(days.isEmpty()||days.peek()<(100-progresses[i])/speeds[i]+1){
	                	if(!days.isEmpty())result.add(count);
	                    days.add((100-progresses[i])/speeds[i]+1);
	                    count=1;
	                }
	                else count++;
	            }
	        }
	        result.add(count);
	        answer=new int[result.size()];
	        int idx=0;
	        for(Integer num: result){
	            answer[idx++]=num;
	        }
	        for(int i=0;i<answer.length;i++) {
	        	System.out.println(answer[i]);
	        }
	        return answer;
	    }
}
