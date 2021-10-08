import java.util.*;
class programmers_모의고사 {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] answers2={2,1,2,3,2,4,2,5};
        int[] answers3={3,1,2,4,5};
        int score1=0, score2=0, score3=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i]==(i%5)+1) score1++;
            
            int answer2=0;
            answer2=answers2[i%8];
            if(answers[i]==answer2) score2++;
            
            int answer3=answers3[(i/2)%5];
            if(answer3==answers[i]) score3++;
        }
        
        int maxscore=Math.max(score1,score2);
        maxscore=Math.max(maxscore,score3);
        int count=0;
        if(score1==maxscore)count++;
        if(score2==maxscore)count++;
        if(score3==maxscore)count++;
        answer=new int[count];
        
        int idx=0;
        if(score1==maxscore) answer[idx++]=1;
        if(score2==maxscore) answer[idx++]=2;
        if(score3==maxscore) answer[idx]=3;
        return answer;
    }
}
