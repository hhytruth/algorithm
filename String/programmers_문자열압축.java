class Solution {
    public int solution(String s) {
        int answer = 0;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=s.length()/2;i++){
            String result="";
            int start=0,end=0;
            String prev="";
            int repeat=0;
            while(true){
                if(start+i>s.length())end=s.length();
                else end=start+i;
                String tmp=s.substring(start,end);
                if(prev.equals(tmp))repeat++;
                else{
                    if(repeat<=1){
                        result+=prev;
                        prev=tmp;
                        repeat=1;
                    }
                    else{
                        result+=repeat+prev;
                        prev=tmp;
                        repeat=1;
                    }
                }
                if(s.length()==end)break;
                start=end;
            }
            if(repeat<=1) result+=prev;
            else result+=repeat+prev;
            
            if(min>result.length())min=result.length();
        }
        if(s.length()==1)return 1;
        return min;
    }
}
