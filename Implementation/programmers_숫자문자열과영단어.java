class programmers_숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;
        String[] numbers={"zero","one","two","three","four","five","six","seven","eight","nine"};
        String tmp="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='0'&&c<='9')answer=answer*10+(c-'0');
            else{
                tmp+=c;
                for(int j=0;j<10;j++){
                    if(numbers[j].equals(tmp)){
                        answer=answer*10+j;
                        tmp="";
                    }
                }
            }
        }
        return answer;
    }
}
