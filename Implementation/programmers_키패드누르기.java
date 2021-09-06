class programmers_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=10;
        int right=11;
        int[] dist2={3,1,0,1,2,1,2,3,2,3,4,4};
        int[] dist5={2,2,1,2,1,0,1,2,1,2,3,3};
        int[] dist8={1,3,2,3,2,1,2,1,0,1,2,2};
        int[] dist0={0,4,3,4,3,2,3,2,1,2,1,1};
        
        for(int i=0;i<numbers.length;i++){
            int number=numbers[i];
            if(number==1||number==4||number==7){
                answer+="L";
                left=number;
            }
            else if(number==3||number==6||number==9){
                answer+="R";
                right=number;
            }
            else{
                if(number==2){
                    if(dist2[left]<dist2[right]||(dist2[left]==dist2[right]&&hand.equals("left"))){
                        answer+="L";
                        left=2;
                    }
                    else{
                        answer+="R";
                        right=2;
                    }
                }
                else if(number==5){
                    if(dist5[left]<dist5[right]||(dist5[left]==dist5[right]&&hand.equals("left"))){
                        answer+="L";
                        left=5;
                    }
                    else{
                        answer+="R";
                        right=5;
                    }
                }
                else if(number==8){
                    if(dist8[left]<dist8[right]||(dist8[left]==dist8[right]&&hand.equals("left"))){
                        answer+="L";
                        left=8;
                    }
                    else{
                        answer+="R";
                        right=8;
                    }
                }
                else if(number==0){
                    if(dist0[left]<dist0[right]||(dist0[left]==dist0[right]&&hand.equals("left"))){
                        answer+="L";
                        left=0;
                    }
                    else{
                        answer+="R";
                        right=0;
                    }
                }
            }
            
        }
        return answer;
    }
}
