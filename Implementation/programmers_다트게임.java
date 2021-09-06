class programmers_다트게임 {
  public static int solution(String dartResult) {
	        int answer = 0;
	        int prev=0;
	        int cur=0;
	        int withBonus=0;
	        int withBonusPrev=0;
	        int prevPrize=0;
	        
	        for(int i=0;i<dartResult.length();i++){
	            char c=dartResult.charAt(i);
	            if(c>='1'&&c<='9'){
	                answer+=withBonus;
	                withBonusPrev=withBonus;
	                cur=c-'0';
	            }
	            else if(c=='0'){
	                if(cur==1)cur=10;
	                else {
	                	answer+=withBonus;
		                withBonusPrev=withBonus;
	                	cur=0;
	                }
	            }
	            else if(c=='S'){
	                withBonus=cur;
	                cur=0;
	                if(dartResult.length()>i+1&&dartResult.charAt(i+1)>='0'&&dartResult.charAt(i+1)<='9') prevPrize=0;
	            }
	            else if(c=='D'){
	                withBonus=cur*cur;
	                cur=0;
	                if(dartResult.length()>i+1&&dartResult.charAt(i+1)>='0'&&dartResult.charAt(i+1)<='9') prevPrize=0;
	            }
	            else if(c=='T'){
	                withBonus=cur*cur*cur;
	                cur=0;
	                if(dartResult.length()>i+1&&dartResult.charAt(i+1)>='0'&&dartResult.charAt(i+1)<='9') prevPrize=0;
	            }
	            else if(c=='*'){
	                if(prevPrize==1)answer+=withBonusPrev*2+withBonus;
	                else if(prevPrize==0)answer+=withBonusPrev+withBonus;
	                else answer+=withBonusPrev*-1+withBonus;
	                prevPrize=1;
	            }
	            else if(c=='#'){
	                prevPrize=2;
	                answer-=withBonus*2;
	            }
	        }
	        answer+=withBonus;
	        return answer;
	    }
	
}
