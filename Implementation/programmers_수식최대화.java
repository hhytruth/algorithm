import java.util.*;

class programmers_수식최대화 {
    public static long solution(String expression) {
        long answer = 0;
        String[][] priorities={{"*","+","-"},{"*","-","+"},{"+","-","*"},{"+","*","-"},{"-","*","+"},{"-","+","*"}};
        ArrayList<String> list=new ArrayList<>();
        int num=0;
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(c!='*'&&c!='-'&&c!='+') num=num*10+(c-'0');
            else{
                list.add(Integer.toString(num));
                num=0;
                list.add(Character.toString(c));
            }
        }
        list.add(Integer.toString(num));
        
        long max=0;
        for(int i=0;i<6;i++){
        	ArrayList<String> list2=(ArrayList)list.clone();
            for(int j=0;j<3;j++){
                String op=priorities[i][j];
                int idx=0;
                while(true){
                    if(list2.get(idx).equals(op)){
                        long n1=Long.parseLong(list2.get(idx-1));
                        long n2=Long.parseLong(list2.get(idx+1));
                        long result=0;
                        if(op.equals("*"))result=n1*n2;
                        else if(op.equals("+"))result=n1+n2;
                        else if(op.equals("-"))result=n1-n2;
                        list2.remove(idx-1);
                        list2.remove(idx-1);
                        list2.remove(idx-1);
                        list2.add(idx-1,Long.toString(result));
                        idx--;
                    }
                    if(idx>=list2.size()-2)break;
                    idx++;

                }  
            }
            Long result=Math.abs(Long.parseLong(list2.get(0)));
            if(result>max)max=result;
        }
        return max;
    }
	
}
