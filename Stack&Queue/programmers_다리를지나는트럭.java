import java.util.*;
class programmers_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge=new LinkedList<>();
	        int sum=0, time=0;
	        for(int i=0;i<bridge_length-1;i++) {
	        	bridge.add(0);
	        }
	        for(int i=0;i<truck_weights.length;i++){
	        	int truck=truck_weights[i];
	        	boolean popped=false;
	            while(sum+truck>weight||bridge.size()>=bridge_length) {
	            	int t=bridge.poll();
	            	sum-=t;
	            	if(sum+truck>weight)bridge.add(0);
	            	time++;
	            	popped=true;
	            }
	            bridge.add(truck);
	            sum+=truck;
	            if(!popped)time++;
	       
	        }
	        
	        while(!bridge.isEmpty()) {
	        	bridge.poll();
	        	time++;
	        }
	        
	        return time;
    }
}
