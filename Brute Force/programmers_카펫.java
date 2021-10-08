class programmers_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int garo=0, sero=0;
        for(int i=1;i<brown/2;i++){
            garo=i;
            sero=brown/2+2-garo;
            if((garo-2)*(sero-2)==yellow) {
                answer[0]=sero;
                answer[1]=garo;
                return answer;
            }
        }
        return answer;
    }
}
