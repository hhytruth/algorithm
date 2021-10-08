class programmers_소수찾기 {
    public static int answer=0;
	public static boolean[] prime;
    public static void perm(String numbers,boolean[] visited,int depth,int number){
        if(depth==numbers.length()) {
        	if(number==0) return;
            if(number==1) return;

            for(int i=2;i*i<=number;i++){
                if(number%i==0)return;
            }
            if(!prime[number]) {
            	answer++;
            	prime[number]=true;
            }
            return;
        }
        
        for(int i=0;i<numbers.length();i++) {
        	if(visited[i])continue;
        	visited[i]=true;
            perm(numbers,visited,depth+1,number*10+(numbers.charAt(i)-'0'));
            visited[i]=false;
            perm(numbers,visited,depth+1,number);
        }
        
        
    }
    
    public static int solution(String numbers) {
    	prime=new boolean[10000000];
        perm(numbers,new boolean[numbers.length()],0,0);
        return answer;
    }
}
