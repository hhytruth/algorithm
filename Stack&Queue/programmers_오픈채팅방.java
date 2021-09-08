import java.util.*;
class programmers_오픈채팅방 {
    public String[] solution(String[] record) {
        Queue<String> log=new LinkedList<>();
        Map<String,String> map=new HashMap<>();
        StringTokenizer st;
        for(int i=0;i<record.length;i++){
            st=new StringTokenizer(record[i]);
            String op=st.nextToken();
            String uid=st.nextToken();
            String name="";
            if(st.hasMoreTokens())name=st.nextToken();

            if(!op.equals("Change"))log.add(uid);
            if(op.equals("Enter"))map.put(uid,name);
            else if(op.equals("Change"))map.put(uid,name);
        }
        Set<String> entering=new HashSet<>();
        int idx=0;
        String[] answer = new String[log.size()];

        while(!log.isEmpty()){
            String uid=log.poll();
            String name=map.get(uid);
            if(entering.contains(uid)){
                entering.remove(uid);
                answer[idx++]=name+"님이 나갔습니다.";
            }
            else{
                entering.add(uid);
                answer[idx++]=name+"님이 들어왔습니다.";
            }
        }
        return answer;
    }
}
