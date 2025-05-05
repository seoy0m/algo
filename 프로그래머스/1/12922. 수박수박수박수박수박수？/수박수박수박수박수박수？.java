class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i =0; i<n; i++){
            if(answer.length()==0 || answer.charAt(answer.length()-1) == '박'){
                answer+= '수';
            } else {
                answer+= '박';
            }
                   }
        return answer;
    }
}