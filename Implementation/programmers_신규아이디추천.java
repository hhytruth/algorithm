class programmers_신규아이디추천 {
   public static String solution(String new_id) {
	        StringBuilder sb=new StringBuilder(new_id);
	        for(int i=0;i<new_id.length();i++){
	            char c=new_id.charAt(i);
	            if(c>='A'&&c<='Z') {
	                char c2=(char)(new_id.charAt(i)+'a'-'A');
	                new_id=new_id.replaceFirst(Character.toString(c),Character.toString(c2));
	                sb=new StringBuilder(new_id);
	            }
	            else if((c<'a'||c>'z')&&c!='.'&&c!='-'&&(c<'0'||c>'9')&&c!='_'){
	                sb.deleteCharAt(i);
	                new_id=sb.toString();
	                sb=new StringBuilder(new_id);
	                i--;
	            }
	        }
	        
	        while(true){
	            String s=new_id.replace("..",".");
	            if(s.equals(new_id))break;
	            new_id=s;
	        }
	        
	        if(new_id.charAt(0)=='.')new_id=new_id.substring(1,new_id.length());
	        if(new_id.length()>1&&new_id.charAt(new_id.length()-1)=='.')new_id=new_id.substring(0,new_id.length()-1);
	        
	        if(new_id.equals(""))new_id="a";
	        
	        if(new_id.length()>=16)new_id=new_id.substring(0,15);
	                if(new_id.charAt(new_id.length()-1)=='.')new_id=new_id.substring(0,new_id.length()-1);

	        while(new_id.length()<=2){
	            new_id+=new_id.charAt(new_id.length()-1);
	        }
	        
	        return new_id;
	    }
	
}
