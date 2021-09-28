import java.util.*;
class programmers_가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String n1,String n2){
                String add1=n1+n2;
                String add2=n2+n1;
                return add2.compareTo(add1);
            }
        
        });
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("0")&&answer.equals("0")) continue;
            answer+=arr[i];
        }
        return answer;
    }
}
