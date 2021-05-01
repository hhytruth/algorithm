import java.util.*;

class Stage implements Comparable<Stage>{
        int num;
        double failrate;
        
        Stage(int n,double f){
            num=n;
            failrate=f;
        }
        
        @Override
        public int compareTo(Stage o){
            if(this.failrate==o.failrate) {
                if(this.num<o.num)return -1;
                else return 1;
            }
            if(this.failrate<o.failrate)return 1;
            else return -1;
        }
    }

class Solution {
    
    
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] cleared=new int[N+1];
        int[] reached=new int[N+1];
        
        for(int i=0;i<stages.length;i++){
            int stage=stages[i];
            for(int j=1;j<stage;j++){
                reached[j]++;
                cleared[j]++;
            }
            if(stage!=N+1) reached[stage]++;
        }
        
        Stage[] arr=new Stage[N];
        for(int i=0;i<N;i++){
            if(reached[i+1]==0)arr[i]=new Stage((i+1),0);
            else arr[i]=new Stage(i+1,(double)((reached[i+1]-cleared[i+1])/(double)reached[i+1]));
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<N;i++){
            answer[i]=arr[i].num;
        }
        
        return answer;
    }
}
