import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int length=board[0].length;
        Stack<Integer>[] stacks=new Stack[length];
        for(int i=0;i<length;i++){
            stacks[i]=new Stack<>();
        }
        for(int i=length-1;i>=0;i--){
            for(int j=0;j<length;j++){
                if(board[i][j]>0)stacks[j].add(board[i][j]);
            }
        }
        
        Stack<Integer> basket=new Stack<>();
        for(int i=0;i<moves.length;i++){
            int idx=moves[i]-1;
            if(!stacks[idx].isEmpty()){
                if(basket.isEmpty()){
                    basket.add(stacks[idx].pop());
                }
                else{
                    if(basket.peek()==stacks[idx].peek()){
                        basket.pop();
                        stacks[idx].pop();
                        answer+=2;
                    }
                    else{
                        basket.add(stacks[idx].pop());
                    }
                }
                
               
            }
        }
        
        return answer;
    }
}
