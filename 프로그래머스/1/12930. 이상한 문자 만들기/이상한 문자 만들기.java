class Solution {
    public String solution(String s) {
        String answer = "";
        int idx =0;
        for(int i=0; i< s.length(); i++){
            
            char c = s.charAt(i);
            
            if(c==' ') {
                idx=0;
                answer+= ' ';
            } else if(idx%2==0){
                if(c>='a' && c<='z'){
                    answer+= (char) ((int) c -32);
                } else{
                    answer += c;
                }
                idx++;
            } else{
                if(c>='A' && c<='Z'){
                    answer+= (char) ((int) c +32);
                } else{
                    answer += c;
                }
                idx++;
            }
            
        }
        return answer;
    }
}