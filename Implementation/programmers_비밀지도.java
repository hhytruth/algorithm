class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
                int tmp1=0,tmp2=0;
                if((arr1[i]&(1<<j))!=0)tmp1=1;
                if((arr2[i]&(1<<j))!=0)tmp2=1;
                
                if(tmp1==1||tmp2==1)s="#"+s;
                else s=" "+s;
            }
            answer[i]=s;
            
        }
        
        return answer;
    }
}
